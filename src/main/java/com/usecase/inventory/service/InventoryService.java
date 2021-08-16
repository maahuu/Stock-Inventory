package com.usecase.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.inventory.entity.Stock;
import com.usecase.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository repo;

	public Optional<Stock> getStockById(Long id) {
		return repo.findById(id);
	}

	public Stock createOrUpdateStock(Stock stock) {
		return repo.save(stock);
	}

	public List<Stock> getStocks() {
		return repo.findAll();
	}

}
