package com.toolofheroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.toolofheroes.exception.HeroNotFoundException;
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

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Hero> findAll() {
		return heroesRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Hero findById(Long id) {
		return heroesRepository.findById(id).orElseThrow(() -> new HeroNotFoundException(id));
	}

	@Transactional
	public void deletar(Long id) {
		findById(id);
		heroesRepository.deleteById(id);
	}

	@Transactional
	public Hero update(Long id, Hero hero) {
		Hero heroUpdate = findById(id);
		heroUpdate.setName(hero.getName());
		heroUpdate.setUrlImage(hero.getUrlImage());
		
		heroesRepository.save(heroUpdate);
		return heroUpdate;
	}

}
