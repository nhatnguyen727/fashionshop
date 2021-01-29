package com.fashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.OrderDetail;
import com.fashion.models.entity.OrderDetailIdentity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailIdentity>{

}
