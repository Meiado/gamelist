package com.gabrielmeiado.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmeiado.gamelist.dto.GameMinDTO;
import com.gabrielmeiado.gamelist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public List<GameMinDTO> findAll(){
    List<GameMinDTO> list = gameService.findAll();
    return list;
  }
}
