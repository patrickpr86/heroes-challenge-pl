package com.patrick.heroeschallengepl.services;

import com.patrick.heroeschallengepl.models.Hero;
import com.patrick.heroeschallengepl.models.Power;
import com.patrick.heroeschallengepl.repositories.HeroRepository;

import com.patrick.heroeschallengepl.repositories.PowerRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HeroService {

  @Autowired
  private HeroRepository heroRepository;

  @Autowired
  private PowerRepository powerRepository;


  @Transactional
  public List<Hero> findAll() {
    List<Hero> heroes = heroRepository.findAll();
    return heroes;
  }

  @Transactional
  public Hero findById(Long id) {
    Optional<Hero> obj = heroRepository.findById(id);
    Hero hero = obj.get();
    return hero;
  }
}