package org.projeto.games.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O gênero é obrigatório")
    @Size(max = 30, message = "O gênero deve ter no máximo 30 caracteres")
    @Column(nullable = false, length = 30)
    private String genero;

    @Size(max = 200, message = "A URL da imagem deve ter no máximo 200 caracteres")
    @Column(length = 200)
    private String imagemUrl;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @Size(max = 150, message = "As plataformas devem ter no máximo 150 caracteres")
    @Column(length = 150)
    private String plataformas;

    @Min(value = 0, message = "O rating mínimo é 0")
    @Max(value = 100, message = "O rating máximo é 100")
    @Column(nullable = false)
    private int rating;

    public Game(String genero, String plataformas, String nome, String imagemUrl, int rating) {
        this.genero = genero;
        this.plataformas = plataformas;
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.rating = rating;
    }

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
