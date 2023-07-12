package com.gabrielmeiado.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielmeiado.gamelist.dto.GameListDTO;
import com.gabrielmeiado.gamelist.entities.GameList;
import com.gabrielmeiado.gamelist.repositories.GameListRepository;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> list = gameListRepository.findAll();
    return list.stream().map(o -> new GameListDTO(o)).toList();
  }

  @Transactional(readOnly = true)
  public GameListDTO findOne(Long id){
    GameList game = gameListRepository.findById(id).get();
    return new GameListDTO(game);
  }
}
