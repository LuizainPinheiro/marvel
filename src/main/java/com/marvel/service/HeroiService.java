package com.marvel.service;

import com.marvel.dto.HeroiEntradaDTO;
import com.marvel.dto.HeroiSaidaDTO;
import com.marvel.exception.RecursoNaoEncontradoException;
import com.marvel.model.Equipe;
import com.marvel.model.Heroi;
import com.marvel.repository.EquipeRepository;
import com.marvel.repository.HeroiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroiService {

    private final HeroiRepository heroiRepository;
    private final EquipeRepository equipeRepository;

    public HeroiService(HeroiRepository heroiRepository, EquipeRepository equipeRepository) {
        this.heroiRepository = heroiRepository;
        this.equipeRepository = equipeRepository;
    }

    public List<HeroiSaidaDTO> listarTodos() {
        return heroiRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public HeroiSaidaDTO buscarPorId(Long id) {
        Heroi heroi = heroiRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Herói não encontrado com o ID: " + id));
        return converterParaDTO(heroi);
    }

    public HeroiSaidaDTO salvar(HeroiEntradaDTO dto) {
        Heroi heroi = new Heroi();
        heroi.setNome(dto.getNome());
        heroi.setAlterEgo(dto.getAlterEgo());
        heroi.setSuperPoder(dto.getSuperPoder());
        heroi.setImagemUrl(dto.getImagemUrl());

        if (dto.getEquipeId() != null) {
            Equipe equipe = equipeRepository.findById(dto.getEquipeId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Equipe não encontrada com o ID: " + dto.getEquipeId()));
            heroi.setEquipe(equipe);
        }

        Heroi heroiSalvo = heroiRepository.save(heroi);
        return converterParaDTO(heroiSalvo);
    }

    private HeroiSaidaDTO converterParaDTO(Heroi heroi) {
        return new HeroiSaidaDTO(
                heroi.getId(),
                heroi.getNome(),
                heroi.getAlterEgo(),
                heroi.getSuperPoder(),
                heroi.getImagemUrl(),
                heroi.getEquipe() != null ? heroi.getEquipe().getNome() : "Sem Equipe"
        );
    }
}