package com.toolofheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	@Operation(summary = "Adicionar novo agente")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HeroDTO> createHero(@RequestBody HeroDTO heroDto) {
		Hero hero = heroMapper.toHero(heroDto);
		Hero heroCriado = heroesService.createHero(hero);
		HeroDTO dto = heroMapper.toDTO(heroCriado);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<HeroDTO>> findAll() {
		List<Hero> list = heroesService.findAll();
		List<HeroDTO> heroesDtoList = heroMapper.toHeroDTOList(list);
		return ResponseEntity.ok(heroesDtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HeroDTO> findById(@PathVariable Long id) {
		Hero hero = heroesService.findById(id);
		HeroDTO dto = heroMapper.toDTO(hero);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		heroesService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HeroDTO> update(@PathVariable Long id, @RequestBody HeroDTO heroDTO) {
		Hero hero = heroMapper.toHero(heroDTO);
		Hero heroParaAtualizar = heroesService.update(id, hero);
		return ResponseEntity.ok(heroMapper.toDTO(heroParaAtualizar));
	}
	

}
