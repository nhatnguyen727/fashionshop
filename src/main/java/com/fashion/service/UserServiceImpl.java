package com.fashion.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.UserDto;
import com.fashion.models.entity.Role;
import com.fashion.models.entity.User;
import com.fashion.models.mapper.UserMapper;
import com.fashion.repositories.RoleRepository;
import com.fashion.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository;
	BCryptPasswordEncoder passEncoder;
	@Autowired
	RoleRepository rolerepository;

	@Autowired
	public void UserService(UserRepository userRepository) {
		this.repository = userRepository;
		this.passEncoder = new BCryptPasswordEncoder();

	}

	@Override
	public User save(UserDto dto) {
		User user = UserMapper.INSTANCE.toEntity(dto);
//		user.setUsername(dto.getUsername());
//		user.setPassword(passEncoder.encode(dto.getPassword()));
//		user.setAddress(dto.getAddress());
//		user.setPhone(dto.getPhone());
//		
//		String passEncoderString = BCrypt.hashpw(dto.getPassword(),BCrypt.gensalt(10));
//		dto.setPassword(passEncoderString);

		user.setIdrole(rolerepository.findById(dto.getIdrole().getId()).get());
		
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

	@Override
	public Object findByUser(String username,String pass) {
		return repository.findByUser(username, pass);
	}


	

	
}
