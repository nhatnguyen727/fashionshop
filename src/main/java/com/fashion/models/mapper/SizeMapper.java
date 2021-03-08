package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.SizeDto;
import com.fashion.models.entity.Size;

@Mapper
public interface SizeMapper {
	SizeMapper INSTANCE = Mappers.getMapper(SizeMapper.class);

	Size toEntity(SizeDto dto);

	SizeDto toDto(Size entity);

	default List<SizeDto> toDtoList(List<Size> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<Size> toEntityList(List<SizeDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
