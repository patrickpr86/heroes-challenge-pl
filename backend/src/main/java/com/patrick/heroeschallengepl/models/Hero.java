package com.patrick.heroeschallengepl.models;

import com.patrick.heroeschallengepl.models.enums.Universe;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Universe universe;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;


  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "hero_id"  )
  private List<Power> powers;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Hero hero = (Hero) o;
    return id != null && Objects.equals(id, hero.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
