package com.usecase.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.inventory.entity.Stock;

@Repository
public interface InventoryRepository extends JpaRepository<Stock, Long> {

}
