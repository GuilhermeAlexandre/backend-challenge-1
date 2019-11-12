package com.invillia.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.exception.ExistingCNPJException;
import com.invillia.acme.model.Store;
import com.invillia.acme.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> get() {
		return storeRepository.findAll();
	}
	
	public Store save(Store store) {
		this.existsByCnpj(store.getCnpj());
		return storeRepository.save(store);
	}
	
	public Store getById(Long storeId) {
		return storeRepository.findOne(storeId);
    }
	
	public Store getByCnpj(String cnpj) {
		return storeRepository.getByCnpj(cnpj);
	}
	
	public void delete(Long storeId) {	
		storeRepository.delete(storeId);
	}
	
	public void update(Store store) {
		storeRepository.save(store);	
	}
	
	public void existsByCnpj(String cnpj) {
		Store cnpjExists = this.getByCnpj(cnpj);
		if (cnpjExists != null) {
			throw new ExistingCNPJException("Store's CNPJ already exists");
		}
	}
	
}
