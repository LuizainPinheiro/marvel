package com.marvel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeReal;
    private String ocupacao;

    @Column(columnDefinition = "TEXT")
    private String poderes;

    @Column(columnDefinition = "TEXT")
    private String inimigos;

    @Column(columnDefinition = "TEXT")
    private String filmes;

    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}