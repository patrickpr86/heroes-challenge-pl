package com.patrick.heroeschallengepl.controllers;

import com.patrick.heroeschallengepl.models.Hero;
import com.patrick.heroeschallengepl.services.HeroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/heroes")
public class HeroController {

  @Autowired
  private HeroService heroService;

  @GetMapping
  public ResponseEntity<Page<Hero>> findAll(Pageable pageable) {
    Page<Hero> heroes = heroService.findAllPaged(pageable);
    return ResponseEntity.ok(heroes);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Hero> findById(@PathVariable Long id) {
    Hero obj = heroService.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
