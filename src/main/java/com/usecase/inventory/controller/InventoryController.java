package com.usecase.inventory.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.usecase.inventory.entity.Stock;
import com.usecase.inventory.exception.StockNotFoundException;
import com.usecase.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService service;
	
	@GetMapping("/stocks")
	public ResponseEntity<List<Stock>> getStocks(){
		List<Stock> stocks = service.getStocks();
		return ResponseEntity.ok().body(stocks);
	}
	
	@GetMapping("/stocks/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable Long id){
		Stock stock = service.getStockById(id)
				.orElseThrow(()->new StockNotFoundException("Stock not found with stock number "+id));
		return ResponseEntity.ok().body(stock);
	}
	
	@PostMapping("/stocks")
	public ResponseEntity<Object> createStock(@Valid @RequestBody Stock stock) {
		Stock newStock = service.createOrUpdateStock(stock);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newStock.getStockNumber()).toUri();
		
		return ResponseEntity.created(location).body(newStock);
	}

	@PutMapping("/stocks/{id}")
	public ResponseEntity<Object> updateStock(@PathVariable Long id,@RequestBody Stock stock) {
		service.getStockById(id)
				.orElseThrow(()->new StockNotFoundException("Stock not found with stock number "+id));
		stock.setStockNumber(id);
		Stock updatedStock=service.createOrUpdateStock(stock);
		return ResponseEntity.ok().body(updatedStock);
	}
}
