package com.fashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.Warehouse;
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

}
