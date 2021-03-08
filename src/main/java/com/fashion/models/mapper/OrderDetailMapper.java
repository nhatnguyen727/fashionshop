package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.OrderDetailDto;
import com.fashion.models.entity.OrderDetail;

@Mapper
public interface OrderDetailMapper {
	OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

	OrderDetail toEntity(OrderDetailDto dto);

	OrderDetailDto toDto(OrderDetail entity);

	default List<OrderDetailDto> toDtoList(List<OrderDetail> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<OrderDetail> toEntityList(List<OrderDetailDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
