package com.patrick.heroeschallengepl.repositories;


import com.patrick.heroeschallengepl.models.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {

}
