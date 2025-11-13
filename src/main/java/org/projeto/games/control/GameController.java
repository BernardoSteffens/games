package org.projeto.games.control;

import jakarta.validation.Valid;
import org.projeto.games.model.Game;
import org.projeto.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/games")
@RestController
public class GameController {

    @Autowired
    GameRepository rep;

    @GetMapping("/")
    public ResponseEntity<List<Game>> getAllGames( @RequestParam(required = false) String genero,
                                                   @RequestParam(required = false) String plataforma,
                                                   @RequestParam(required = false) String nome,
                                                   @RequestParam(required = false, defaultValue = "false") boolean ordenarPorNomeDesc,
                                                   @RequestParam(required = false, defaultValue = "false") boolean ordenarPorRatingAsc,
                                                   @RequestParam(required = false, defaultValue = "false") boolean ordenarPorRatingDesc) {
        try {
            Specification<Game> spec = (root, query, cb) -> cb.conjunction();

            if (nome != null && !nome.isBlank()) {
                String nomeLower = "%" + nome.toLowerCase() + "%";
                spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("nome")), nomeLower));
            }

            if (genero != null && !genero.isBlank()) {
                String generoLower = "%" + genero.toLowerCase() + "%";
                spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("genero")), generoLower));
            }

            if (plataforma != null && !plataforma.isBlank()) {
                String plataformaLower = "%" + plataforma.toLowerCase() + "%";
                spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("plataformas")), plataformaLower));
            }

            Sort sort = Sort.by(Sort.Order.asc("nome"));;

            if(ordenarPorRatingDesc){
                sort  = Sort.by(Sort.Order.desc("rating"));
            } else if (ordenarPorRatingAsc) {
                sort = Sort.by(Sort.Order.asc("rating"));
            } else if (ordenarPorNomeDesc) {
                sort = Sort.by(Sort.Order.desc("nome"));
            }

            List<Game> lista = rep.findAll(spec, sort);

            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Game> createGame(@Valid @RequestBody Game ga) {
        try {
            Game t = rep.save(new Game(
                    ga.getGenero(),
                    ga.getPlataformas(),
                    ga.getNome(),
                    ga.getImagemUrl(),
                    ga.getRating()
            ));
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") long id){
        try{
            Optional<Game> data = rep.findById(id);

            if(data.isPresent()){
                return new ResponseEntity<>(data.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") Long id, @Valid @RequestBody Game g){
        try {
            Optional<Game> data = rep.findById(id);

            if(data.isPresent()){

                Game ga = data.get();
                ga.setNome(g.getNome());
                ga.setGenero(g.getGenero());
                ga.setPlataformas(g.getPlataformas());
                ga.setRating(g.getRating());
                ga.setImagemUrl(g.getImagemUrl());

                return new ResponseEntity<>(rep.save(ga), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteTarefa(@PathVariable("id") Long id){
        try{
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
