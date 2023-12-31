package com.gabrielmeiado.gamelist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_list")
public class GameList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  public GameList() {
  }

  public GameList(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if(o == null)
      return false;
    if(getClass() != o.getClass())
      return false;
    GameList list = (GameList) o;
    return Objects.equals(id, list.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
