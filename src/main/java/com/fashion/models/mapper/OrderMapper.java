package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.OrderDto;
import com.fashion.models.entity.Order;


@Mapper
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	Order toEntity(OrderDto dto);

	OrderDto toDto(Order entity);

	default List<OrderDto> toDtoList(List<Order> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<Order> toEntityList(List<OrderDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
