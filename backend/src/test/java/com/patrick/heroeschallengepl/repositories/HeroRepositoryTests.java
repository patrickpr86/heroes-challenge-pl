package com.patrick.heroeschallengepl.repositories;

import com.patrick.heroeschallengepl.models.Hero;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class HeroRepositoryTests {

  @Autowired
  private HeroRepository heroRepository;

  @Test
  public void findByShouldRetrieveObjectWhenIdExists() {

    long existingId = 1L;
    Optional<Hero> result = heroRepository.findById(existingId);
    Assertions.assertTrue(result.isPresent());
  }

  @Test void findAllShouldRetrieveListOfObjectWhenExists() {

    List<Hero> list = heroRepository.findAll();
        Assertions.assertFalse(list.isEmpty());


  }
}
