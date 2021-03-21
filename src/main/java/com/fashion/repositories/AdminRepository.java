package com.fashion.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.Admin;
@Repository
public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	@Query(value = "select a.name, a.password, 'admin' as role from admin a where a.name= :username and a.password = :pass group by a.name, a.password", nativeQuery = true)
	Object findByUsername(String username, String pass);
	
}
