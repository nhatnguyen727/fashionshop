package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.RoleDto;
import com.fashion.models.entity.Role;
@Mapper
public interface RoleMapper {
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	Role toEntity(RoleDto roleDto);
	
	RoleDto toDto(Role roleEntity);
	
	default List<RoleDto> toDtoList(List<Role> classList){
		if(classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}
	default List<Role> toEntityList(List<RoleDto> classList){
		if(classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
