package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.UserDto;
import com.fashion.models.entity.User;
import com.fashion.models.mapper.UserMapper;
import com.fashion.repositories.RoleRepository;
import com.fashion.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	 UserRepository repository;
	 PasswordEncoder passEncoder;
	 @Autowired
	 RoleRepository rolerepository;
	 @Autowired
	 public void UserService(UserRepository userRepository) {
		 this.repository = userRepository;
		 this.passEncoder = new BCryptPasswordEncoder();
		 
	 }
	@Override
	public User save(UserDto dto) {
		
		String passEncoderString = this.passEncoder.encode(dto.getPassword());
		dto.setPassword(passEncoderString);
		User user = UserMapper.INSTANCE.toEntity(dto);
		user.setIdrole(rolerepository.findById(dto.getIdrole().getId()).get());;
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<User> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
