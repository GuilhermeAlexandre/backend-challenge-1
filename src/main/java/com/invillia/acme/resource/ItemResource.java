package com.invillia.acme.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.invillia.acme.model.Item;
import com.invillia.acme.service.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemResource {
	@Autowired
	private ItemService itemService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Item>> get() {
		return ResponseEntity.status(HttpStatus.OK).body(itemService.get());
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable("id") Long itemId) {
		Item item = itemService.getById(itemId);

		if (item == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(item);
	}

	@CrossOrigin
	@RequestMapping(value = "/sku/{sku}", method = RequestMethod.GET)
	public ResponseEntity<?> getBySku(@PathVariable("sku") String sku) {
		Item item = itemService.getBySku(sku);

		if (item == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(item);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Item item) {
		//try {
			item = itemService.save(item);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long itemId) {
		try {
			itemService.delete(itemId);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Item item, @PathVariable("id") Long itemId) {
		item.setId(itemId);
		itemService.update(item);
		return ResponseEntity.noContent().build();
	}
}
