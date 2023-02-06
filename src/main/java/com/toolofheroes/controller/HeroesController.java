package com.toolofheroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toolofheroes.dto.HeroDTO;
import com.toolofheroes.mapper.HeroMapper;
import com.toolofheroes.models.Hero;
import com.toolofheroes.services.HeroesService;

@RestController
@RequestMapping("/api/heroes")
@CrossOrigin(origins = "http://localhost:4200/")
public class HeroesController {
	
	private HeroesService heroesService;
	private HeroMapper heroMapper;
	
	@Autowired
	public HeroesController(HeroesService heroservice, HeroMapper heroMapper) {
		this.heroesService = heroservice;
		this.heroMapper = heroMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HeroDTO> createHero(@RequestBody HeroDTO heroDto) {
		Hero hero = heroMapper.toHero(heroDto);
		Hero heroCriado = heroesService.createHero(hero);
		HeroDTO dto = heroMapper.toDTO(heroCriado);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	

}
