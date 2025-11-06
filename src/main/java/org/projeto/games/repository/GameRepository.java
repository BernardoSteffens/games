package org.projeto.games.repository;

import org.projeto.games.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {

    List<Game> findByNomeContainingIgnoreCase(String nome);

    List<Game> findByGeneroContainingIgnoreCase(String genero);

    List<Game> findByPlataformasContainingIgnoreCase(String plataforma);

    List<Game> findAllByOrderByRatingDesc();

}
