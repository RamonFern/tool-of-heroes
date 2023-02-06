package com.toolofheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolofheroes.models.Hero;

public interface HeroesRepository extends JpaRepository<Hero, Long>{

}
