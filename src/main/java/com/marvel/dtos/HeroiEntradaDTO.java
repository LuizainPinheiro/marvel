package com.marvel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HeroiEntradaDTO {

    @NotBlank(message = "O nome do herói é obrigatório")
    private String nome;

    private String alterEgo;
    private String superPoder;
    private String imagemUrl;
    private Long equipeId;
}