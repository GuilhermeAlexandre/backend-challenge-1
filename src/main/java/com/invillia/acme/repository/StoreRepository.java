package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
	public Store getByCnpj(String cnpj);
}
