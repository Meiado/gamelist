package com.gabrielmeiado.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielmeiado.gamelist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
