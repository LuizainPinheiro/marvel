package com.marvel.service;

import com.marvel.dtos.EquipeSaidaDTO;
import com.marvel.dtos.HeroiSaidaDTO;
import com.marvel.model.Equipe;
import com.marvel.repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public List<EquipeSaidaDTO> listarTodas() {
        return equipeRepository.findAll().stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public EquipeSaidaDTO buscarPorNome(String nome) {
        Equipe equipe = equipeRepository.findByNomeContainingIgnoreCase(nome)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com o nome: " + nome));
        return converterParaDTO(equipe);
    }

    private EquipeSaidaDTO converterParaDTO(Equipe equipe) {
        EquipeSaidaDTO dto = new EquipeSaidaDTO();
        dto.setId(equipe.getId());
        dto.setNome(equipe.getNome());
        dto.setOrigem(equipe.getOrigem());
        dto.setImagemUrl(equipe.getImagemUrl());

        if (equipe.getHerois() != null) {
            dto.setHerois(equipe.getHerois().stream().map(heroi -> {
                HeroiSaidaDTO hDto = new HeroiSaidaDTO();
                hDto.setId(heroi.getId());
                hDto.setNome(heroi.getNome());
                hDto.setNomeReal(heroi.getNomeReal());
                hDto.setOcupacao(heroi.getOcupacao());
                hDto.setPoderes(heroi.getPoderes());
                hDto.setInimigos(heroi.getInimigos());
                hDto.setFilmes(heroi.getFilmes());
                hDto.setImagemUrl(heroi.getImagemUrl());
                hDto.setEquipeId(equipe.getId());
                hDto.setNomeEquipe(equipe.getNome());
                return hDto;
            }).toList());
        }
        return dto;
    }
}