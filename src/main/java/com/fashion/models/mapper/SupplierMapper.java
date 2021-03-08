package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.SupplierDto;
import com.fashion.models.entity.Supplier;

@Mapper
public interface SupplierMapper {
	SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

	Supplier toEntity(SupplierDto dto);

	SupplierDto toDto(Supplier entity);

	default List<SupplierDto> toDtoList(List<Supplier> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<Supplier> toEntityList(List<SupplierDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
