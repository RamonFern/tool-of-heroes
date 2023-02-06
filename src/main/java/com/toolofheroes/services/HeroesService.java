package com.toolofheroes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolofheroes.models.Hero;
import com.toolofheroes.repository.HeroesRepository;

@Service
public class HeroesService {
	
	private HeroesRepository heroesRepository;
	
	@Autowired
	public HeroesService(HeroesRepository heroesRepository) {
		this.heroesRepository = heroesRepository;
	}
	
	public Hero createHero(Hero hero) {
		return heroesRepository.save(hero);
	}

}
