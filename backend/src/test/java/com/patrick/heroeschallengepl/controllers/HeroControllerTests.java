package com.patrick.heroeschallengepl.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.patrick.heroeschallengepl.models.Hero;
import com.patrick.heroeschallengepl.models.Power;
import com.patrick.heroeschallengepl.models.enums.Universe;
import com.patrick.heroeschallengepl.services.HeroService;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(HeroController.class)
public class HeroControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private HeroService heroService;

  private Long existingId;
  private Long nonExistingId;
  private Hero hero;
  private PageImpl<Hero> page;


  @BeforeEach
  void setUp() throws Exception {

    existingId = 1L;
    nonExistingId = 2L;

    hero = new Hero(1L, "Yone", Universe.EY_COMICS, Instant.parse("2020-10-20T03:00:00Z"),
        List.of(new Power("hasagi")));
    page = new PageImpl<>(List.of(hero));

    Mockito.when(heroService.findAllPaged(Mockito.any())).thenReturn(page);

    Mockito.when(heroService.findById(existingId)).thenReturn(hero);
  }


  @Test
  public void findAllShouldReturnPage() throws Exception {

    ResultActions result =
        mockMvc.perform(get("/heroes")
            .accept(MediaType.APPLICATION_JSON));

    result.andExpect(status().isOk());
  }

  @Test
  public void findByIdShouldReturnHeroesWhenIdExists() throws Exception {

    ResultActions result =
        mockMvc.perform(get("/heroes/{id}", existingId)
            .accept(MediaType.APPLICATION_JSON));

    result.andExpect(status().isOk());
    result.andExpect(jsonPath("$.id").exists());
    result.andExpect(jsonPath("$.name").exists());
    result.andExpect(jsonPath("$.universe").exists());
//
  }

}
