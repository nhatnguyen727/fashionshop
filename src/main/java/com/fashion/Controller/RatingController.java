package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fashion.Exception.RatingNotFoundException;
import com.fashion.models.dto.RatingDto;
import com.fashion.models.entity.Rating;
import com.fashion.models.mapper.RatingMapper;
import com.fashion.service.RatingService;

@RestController
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@CrossOrigin
	@GetMapping("/ratings")
	public List<RatingDto> list() {
		List<Rating> list = ratingService.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return RatingMapper.INSTANCE.toDtoList(list);
	}

	@CrossOrigin
	@PostMapping("/rating")
	public RatingDto insert(@RequestBody RatingDto dto) {
		Rating rating = ratingService.save(dto);
		return RatingMapper.INSTANCE.toDto(rating);
	}

	@CrossOrigin
	@PutMapping("/rating/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody RatingDto dto) {
		Rating rating = ratingService.findById(id)
				.orElseThrow(() -> new RatingNotFoundException("No rating with " + id));
		Rating nRating = RatingMapper.INSTANCE.toEntity(dto);
		nRating.setId(rating.getId());
		ratingService.save(RatingMapper.INSTANCE.toDto(nRating));
		return ResponseEntity.ok().body("Rating with " + id + " updated!!!");
	}

	@CrossOrigin
	@GetMapping("/rating/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id) {
		Rating rating = ratingService.findById(id)
				.orElseThrow(() -> new RatingNotFoundException("No rating with " + id));
		ratingService.deleteById(rating.getId());
		return ResponseEntity.ok().body("Rating with " + id + " deleted!!!");

	}

}
