package com.fashion.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.Supplier;

@Repository
public interface SupperlierRepository extends JpaRepository< Supplier, Integer>{

	

}
