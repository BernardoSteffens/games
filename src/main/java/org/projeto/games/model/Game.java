package org.projeto.games.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String genero;

    @Column(length = 200)
    private String imagemUrl;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 150)
    private String plataformas;

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
