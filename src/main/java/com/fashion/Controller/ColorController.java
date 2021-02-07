package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Exception.ColorNotFoundException;
import com.fashion.models.dto.ColorDto;
import com.fashion.models.entity.Color;
import com.fashion.models.mapper.ColorMapper;
import com.fashion.service.ColorService;

@RestController
public class ColorController {
	@Autowired
	private ColorService  colorService;
	@GetMapping("/colors")
	public List<ColorDto> list(){
		List<Color> list = colorService.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return ColorMapper.INSTANCE.toDtoList(list);
	}
	@PostMapping("/color")
	public ColorDto insert(@RequestBody ColorDto dto) {
		Color color = colorService.save(dto);
		return ColorMapper.INSTANCE.toDto(color);
	}
	@PutMapping("/color/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id")@Min(1) Integer id, @RequestBody ColorDto dto){
		Color color = colorService.findById(id).orElseThrow(() -> new ColorNotFoundException("No color with "+ id));
		Color nColor = ColorMapper.INSTANCE.toEntity(dto);
		nColor.setId(color.getId());
		colorService.save(ColorMapper.INSTANCE.toDto(nColor));
		return ResponseEntity.ok().body("Color with "+id+" updated!!!");
	}
	@GetMapping("/color/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Color color = colorService.findById(id).orElseThrow(() -> new ColorNotFoundException("No color with "+ id));
		colorService.deleteById(color.getId());
		return ResponseEntity.ok().body("Color with "+id+" deleted!!!");
	}
}
