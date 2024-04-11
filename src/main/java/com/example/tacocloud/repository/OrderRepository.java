package com.example.tacocloud.repository;

import com.example.tacocloud.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
