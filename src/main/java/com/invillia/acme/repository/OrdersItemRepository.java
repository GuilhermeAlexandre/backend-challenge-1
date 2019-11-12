package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.OrdersItem;

public interface OrdersItemRepository extends JpaRepository<OrdersItem, Long> {

}
