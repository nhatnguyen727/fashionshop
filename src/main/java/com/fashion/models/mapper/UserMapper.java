package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.UserDto;
import com.fashion.models.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toEntity(UserDto dto);

	UserDto toDto(User entity);

	default List<UserDto> toDtoList(List<User> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<User> toEntityList(List<UserDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
