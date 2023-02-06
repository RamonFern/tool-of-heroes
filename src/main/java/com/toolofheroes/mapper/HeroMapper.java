package com.toolofheroes.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.toolofheroes.dto.HeroDTO;
import com.toolofheroes.models.Hero;

@Component
public class HeroMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	
	public Hero toHero(HeroDTO dto) {
		return MODEL_MAPPER.map(dto, Hero.class);
	}
	
	public HeroDTO toDTO(Hero hero) {
		return MODEL_MAPPER.map(hero, HeroDTO.class);
	}
	
	public List<HeroDTO> toHeroDTOList(List<Hero> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	}
	

}
