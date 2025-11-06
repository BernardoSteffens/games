package org.projeto.games.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 30)
    private String genero;

    @Column(length = 150)
    private String plataformas;

    @Column(nullable = false)
    private int rating;

    @Column(length = 200)
    private String imagemUrl;

    public Game(String nome, String genero, String plataformas, int rating, String imagemUrl) {
        this.nome = nome;
        this.genero = genero;
        this.plataformas = plataformas;
        this.rating = rating;
        this.imagemUrl = imagemUrl;
    }

    public Game() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
