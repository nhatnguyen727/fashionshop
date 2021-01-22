package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.AdminDto;
import com.fashion.models.entity.Admin;
@Mapper
public interface AdminMapper {
	AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
	
	Admin toEntity(AdminDto adminDto);
	
	AdminDto toDto(Admin adminEntity);
	
	default List<AdminDto> toDtoList(List<Admin> classList){
		if(classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}
	default List<Admin> toEntityList(List<AdminDto> classList){
		if(classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
