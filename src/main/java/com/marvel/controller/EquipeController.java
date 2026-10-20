package com.marvel.controller;

import com.marvel.model.Equipe;
import com.marvel.repository.EquipeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@CrossOrigin(origins = "*")
public class EquipeController {

    private final EquipeRepository equipeRepository;

    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> listarTodas() {
        return ResponseEntity.ok(equipeRepository.findAll());
    }
}