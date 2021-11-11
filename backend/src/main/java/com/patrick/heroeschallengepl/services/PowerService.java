package com.patrick.heroeschallengepl.services;

import com.patrick.heroeschallengepl.models.Hero;
import com.patrick.heroeschallengepl.models.Power;
import com.patrick.heroeschallengepl.repositories.HeroRepository;
import com.patrick.heroeschallengepl.repositories.PowerRepository;
import java.lang.reflect.MalformedParametersException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException.NotFound;

@Service
public class PowerService {

  @Autowired
  private PowerRepository powerRepository;


  @Transactional(readOnly = true)
  public Page<Power> findAllPaged(Pageable pageable) {
    return powerRepository.findAll(pageable);
  }

  @Transactional
  public Power findById(Long id) {
    Optional<Power> obj = powerRepository.findById(id);
    return obj.orElseThrow(() -> new MalformedParametersException("Entity not found"));
  }
}
