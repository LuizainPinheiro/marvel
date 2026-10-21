package com.marvel.dtos;

import lombok.Data;
import java.util.List;

@Data
public class EquipeSaidaDTO {
    private Long id;
    private String nome;
    private String origem;
    private String imagemUrl;
    private List<HeroiSaidaDTO> herois;
}