package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Item;

@Service
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Item getBySku(String sku);
}
