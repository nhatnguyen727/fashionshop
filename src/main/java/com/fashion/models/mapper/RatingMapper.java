package com.fashion.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fashion.models.dto.RatingDto;
import com.fashion.models.entity.Rating;

@Mapper
public interface RatingMapper {
	RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);
	Rating toEntity(RatingDto dto);
	RatingDto toDto(Rating entity);
	default List<RatingDto> toDtoList(List<Rating> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<Rating> toEntityList(List<RatingDto> classList) {
		if (classList == null)
			return new ArrayList<>();
		return classList.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
