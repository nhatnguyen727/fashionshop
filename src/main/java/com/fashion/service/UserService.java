package com.fashion.service;

import java.util.List;
import java.util.Optional;


import com.fashion.models.dto.UserDto;
import com.fashion.models.entity.User;

public interface UserService {

	void deleteById(Integer id);

	Optional<User> findById(Integer id);

	List<User> findAll();

	User save(UserDto dto);

	Object findByUser(String username, String pass);


}
