package com.gabrielmeiado.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmeiado.gamelist.dto.GameMinDTO;
import com.gabrielmeiado.gamelist.entities.Game;
import com.gabrielmeiado.gamelist.repositories.GameRepository;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll() {
    List<Game> list = gameRepository.findAll();
    return list.stream().map(o -> new GameMinDTO(o)).toList();
  }
}
