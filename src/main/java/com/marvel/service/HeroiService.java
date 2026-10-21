package com.marvel.service;

import com.marvel.dtos.HeroiSaidaDTO;
import com.marvel.model.Heroi;
import com.marvel.repository.HeroiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiService {

    private final HeroiRepository heroiRepository;

    public HeroiService(HeroiRepository heroiRepository) {
        this.heroiRepository = heroiRepository;
    }

    public List<HeroiSaidaDTO> listarTodos() {
        return heroiRepository.findAll().stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public HeroiSaidaDTO buscarPorId(Long id) {
        Heroi heroi = heroiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herói não encontrado"));
        return converterParaDTO(heroi);
    }

    private HeroiSaidaDTO converterParaDTO(Heroi heroi) {
        HeroiSaidaDTO dto = new HeroiSaidaDTO();
        dto.setId(heroi.getId());
        dto.setNome(heroi.getNome());
        dto.setNomeReal(heroi.getNomeReal());
        dto.setOcupacao(heroi.getOcupacao());
        dto.setPoderes(heroi.getPoderes());
        dto.setInimigos(heroi.getInimigos());
        dto.setFilmes(heroi.getFilmes());
        dto.setImagemUrl(heroi.getImagemUrl());

        if (heroi.getEquipe() != null) {
            dto.setEquipeId(heroi.getEquipe().getId());
            dto.setNomeEquipe(heroi.getEquipe().getNome());
        }
        return dto;
    }
}