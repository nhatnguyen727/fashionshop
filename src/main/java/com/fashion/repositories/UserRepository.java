package com.fashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "select user.username, user.password, 'user' as role from user where user.username = :username and user.password = :pass group by user.username, user.password", nativeQuery = true)
	Object findByUser(String username, String pass);
}
