package com.patrick.heroeschallengepl.repositories;


import com.patrick.heroeschallengepl.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {



}
