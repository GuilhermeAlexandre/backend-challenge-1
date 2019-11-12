package com.invillia.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.invillia.acme.exception.ExistingSkuException;
import com.invillia.acme.exception.ItemNotFoundException;
import com.invillia.acme.model.Item;
import com.invillia.acme.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> get() {
		return itemRepository.findAll();
	}

	public Item save(Item item) {
		this.existsBySky(item.getSku());
		return itemRepository.save(item);
	}

	public Item getById(Long itemId) {
		return itemRepository.findOne(itemId);
	}

	public Item getBySku(String sku) {
		return itemRepository.getBySku(sku);
	}

	public void delete(Long itemId) {
		itemRepository.delete(itemId);
	}

	public void update(Item item) {
		itemRepository.save(item);

	}

	public void existsBySky(String sku) {
		Item skuExists = this.getBySku(sku);
		if (skuExists != null) {
			throw new ExistingSkuException("Product's SKU already exists");
		}
	}
}
