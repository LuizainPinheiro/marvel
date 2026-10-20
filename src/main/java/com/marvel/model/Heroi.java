package com.marvel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_herois")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Heroi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String alterEgo;
    private String superPoder;
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}