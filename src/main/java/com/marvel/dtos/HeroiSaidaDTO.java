package com.marvel.dtos;

import lombok.Data;

@Data
public class HeroiSaidaDTO {
    private Long id;
    private String nome;
    private String nomeReal;
    private String ocupacao;
    private String poderes;
    private String inimigos;
    private String filmes;
    private String imagemUrl;
    private Long equipeId;
    private String nomeEquipe;
}