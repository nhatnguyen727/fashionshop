package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.DiscountDto;
import com.fashion.models.entity.Discount;

@Mapper
public interface DiscountMapper {
	DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

	Discount toEntity(DiscountDto dto);

	DiscountDto toDto(Discount entity);

	default List<DiscountDto> toDtoList(List<Discount> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<Discount> toEntityList(List<DiscountDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
