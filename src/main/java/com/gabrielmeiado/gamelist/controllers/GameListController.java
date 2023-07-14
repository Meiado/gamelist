package com.gabrielmeiado.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmeiado.gamelist.dto.GameListDTO;
import com.gabrielmeiado.gamelist.dto.GameMinDTO;
import com.gabrielmeiado.gamelist.dto.ReplacementDTO;
import com.gabrielmeiado.gamelist.services.GameListService;
import com.gabrielmeiado.gamelist.services.GameService;


@RestController
@RequestMapping(value = "/lists")
public class GameListController {

  @Autowired
  private GameListService gameListService;

  @Autowired
  private GameService gameService;

  @GetMapping
  public List<GameListDTO> findAll(){
    List<GameListDTO> list = gameListService.findAll();
    return list;
  }

  @GetMapping(value = "/{listId}/games")
  public List<GameMinDTO> findByList(@PathVariable Long listId){
    List<GameMinDTO> list = gameService.findByList(listId);
    return list;
  }

  @PostMapping(value = "/{listId}/replacement")
  public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
    gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
  }
}
