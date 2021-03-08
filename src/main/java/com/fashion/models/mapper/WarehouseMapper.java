package com.fashion.models.mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.WarehouseDto;
import com.fashion.models.entity.Warehouse;

@Mapper
public interface WarehouseMapper {
	WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
	Warehouse toEntity(WarehouseDto dto);
	WarehouseDto toDto(Warehouse entity);

default List<WarehouseDto> toDtoList(List<Warehouse> classList){
		if(classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}


	default List<Warehouse> toEntityList(List<WarehouseDto> classList){
		if(classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
