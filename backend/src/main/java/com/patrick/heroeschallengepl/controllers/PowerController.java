package com.patrick.heroeschallengepl.controllers;

import com.patrick.heroeschallengepl.models.Power;
import com.patrick.heroeschallengepl.services.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/powers")
public class PowerController {

  @Autowired
  private PowerService powerService;

  @GetMapping
  public ResponseEntity<Page<Power>> findAllPaged(Pageable pageable) {
    Page<Power> list = powerService.findAllPaged(pageable);
    return ResponseEntity.ok(list);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Power> findBy(@PathVariable Long id) {
    Power power = powerService.findById(id);
    return ResponseEntity.ok(power);
  }

}
