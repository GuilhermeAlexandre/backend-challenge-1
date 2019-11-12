package com.invillia.acme.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.invillia.acme.model.Store;
import com.invillia.acme.service.StoreService;

@RestController
@RequestMapping(value = "/store")
public class StoreResource {
	@Autowired
	private StoreService storeService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces=
				{ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Store>> get() {
		return ResponseEntity.status(HttpStatus.OK).body(storeService.get());
	}
	
	@CrossOrigin
	@RequestMapping(value= "/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable("id") Long storeId) {
		return ResponseEntity.status(HttpStatus.OK).body(storeService.getById(storeId));
	}
	
	@CrossOrigin
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Store store) {
		store = storeService.save(store);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(store.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value= "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long storeId) {
		try {
			storeService.delete(storeId);
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value= "/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Store store, @PathVariable("id") Long storeId) {
		store.setId(storeId);
		storeService.update(store);
		return ResponseEntity.noContent().build();
	}
}
