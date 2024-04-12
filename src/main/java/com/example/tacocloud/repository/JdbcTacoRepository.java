package com.example.tacocloud.repository;

import com.example.tacocloud.domain.Ingredient;
import com.example.tacocloud.domain.Taco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

@Repository
public class JdbcTacoRepository implements TacoRepository {

    private JdbcTemplate jdbc;

    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {
        //Сохранение основной информации о Taco и получение ее идентификатора
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);

        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }

//        Iterator var4 = taco.getIngredients().iterator();


//        while(var4.hasNext()) {
//            System.out.println(var4);
//            Ingredient ingredient = (Ingredient)var4.next();
//            this.saveIngredientToTaco(ingredient, tacoId);
//        }

        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        // Устанавливаем текущее время создания Taco
        taco.setCreatedAt(new Date());

        // Создаем фабрику для создания PreparedStatementCreator
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory(
                "insert into taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        );
        // Устанавливаем флаг, чтобы получить сгенерированные ключи после выполнения запроса
        creatorFactory.setReturnGeneratedKeys(true);

        // Создаем PreparedStatementCreator с параметрами имени Taco и времени создания
        PreparedStatementCreator psc = creatorFactory.newPreparedStatementCreator(
                // Передаем в качестве параметров имя Taco и время создания, преобразованное в Timestamp
                Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));

        // Создаем объект для хранения сгенерированных ключей
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);

        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update(
                "insert into taco_ingredient (taco, ingredient) " +
                        "values (?, ?)",
                Long.valueOf(tacoId), ingredient.getId());
    }

}
