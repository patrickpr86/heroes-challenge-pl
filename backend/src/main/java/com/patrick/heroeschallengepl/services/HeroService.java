package com.patrick.heroeschallengepl.services;

import com.patrick.heroeschallengepl.models.Hero;
import com.patrick.heroeschallengepl.repositories.HeroRepository;
import com.patrick.heroeschallengepl.repositories.PowerRepository;
import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HeroService {

  @Autowired
  private HeroRepository heroRepository;

  @Autowired
  private PowerRepository powerRepository;


  @Transactional(readOnly = true)
  public Page<Hero> findAllPaged(Pageable pageable) {
    return heroRepository.findAll(pageable);
  }

  @Transactional
  public Hero findById(Long id) {
    Optional<Hero> obj = heroRepository.findById(id);
    return obj.orElseThrow(() -> new MalformedParametersException("Entity not found"));
  }
}
