package com.patrick.heroeschallengepl.repositories;


import com.patrick.heroeschallengepl.models.Hero;
import com.patrick.heroeschallengepl.models.Power;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {



}
