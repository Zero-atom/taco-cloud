delete from taco_order_taco;
delete from taco_ingredient;
delete from taco;
delete from taco_order;

delete from ingredient;
insert into ingredient (id, name, type)
values ('FLTO', 'Пшеничная  лепешка', 'WRAP');
insert into ingredient (id, name, type)
values ('COTO', 'Кукурузная лепешка', 'WRAP');
insert into ingredient (id, name, type)
values ('GRBF', 'Говядина', 'PROTEIN');
insert into ingredient (id, name, type)
values ('CARN', 'Свинина', 'PROTEIN');
insert into ingredient (id, name, type)
values ('TMTO', 'Помидоры', 'VEGGIES');
insert into ingredient (id, name, type)
values ('LETC', 'Салат', 'VEGGIES');
insert into ingredient (id, name, type)
values ('CHED', 'Чеддер', 'CHEESE');
insert into ingredient (id, name, type)
values ('JACK', 'Джек', 'CHEESE');
insert into ingredient (id, name, type)
values ('SLSA', 'Сальса', 'SAUCE');
insert into ingredient (id, name, type)
values ('SRCR', 'Сметана', 'SAUCE');