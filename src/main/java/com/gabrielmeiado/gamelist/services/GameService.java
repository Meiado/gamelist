package com.gabrielmeiado.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielmeiado.gamelist.dto.GameDTO;
import com.gabrielmeiado.gamelist.dto.GameMinDTO;
import com.gabrielmeiado.gamelist.entities.Game;
import com.gabrielmeiado.gamelist.repositories.GameRepository;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> list = gameRepository.findAll();
    return list.stream().map(o -> new GameMinDTO(o)).toList();
  }

  @Transactional(readOnly = true)
  public GameDTO findOne(Long id){
    Game game = gameRepository.findById(id).get();
    return new GameDTO(game);
  }
}
