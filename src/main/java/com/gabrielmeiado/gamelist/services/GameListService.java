package com.gabrielmeiado.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielmeiado.gamelist.dto.GameListDTO;
import com.gabrielmeiado.gamelist.entities.GameList;
import com.gabrielmeiado.gamelist.projections.GameMinProjection;
import com.gabrielmeiado.gamelist.repositories.GameListRepository;
import com.gabrielmeiado.gamelist.repositories.GameRepository;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Autowired
  private GameRepository gameRepository;

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

  @Transactional
  public void move(Long listId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> list = gameRepository.searchByList(listId);
    GameMinProjection obj = list.remove(sourceIndex);
    list.add(destinationIndex, obj);

    int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;
    for (int i = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
  }
}
