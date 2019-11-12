package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Orders;

@Service
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
