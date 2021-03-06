package com.fashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository< Order, Integer>{

}
