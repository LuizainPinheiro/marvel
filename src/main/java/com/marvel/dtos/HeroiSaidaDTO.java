package com.marvel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroiSaidaDTO {

    private Long id;
    private String nome;
    private String alterEgo;
    private String superPoder;
    private String imagemUrl;
    private String nomeEquipe;
}