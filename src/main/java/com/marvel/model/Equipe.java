package com.marvel.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tb_equipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String origem;
    private String imagemUrl;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private List<Heroi> herois;
}