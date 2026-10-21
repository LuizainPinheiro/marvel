package com.marvel.controller;

import com.marvel.dtos.EquipeSaidaDTO;
import com.marvel.service.EquipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@CrossOrigin(origins = "*")
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping
    public List<EquipeSaidaDTO> listarTodas() {
        return equipeService.listarTodas();
    }

    @GetMapping("/busca")
    public EquipeSaidaDTO buscarPorNome(@RequestParam String nome) {
        return equipeService.buscarPorNome(nome);
    }
}