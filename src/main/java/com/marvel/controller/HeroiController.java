package com.marvel.controller;

import com.marvel.dto.HeroiEntradaDTO;
import com.marvel.dto.HeroiSaidaDTO;
import com.marvel.service.HeroiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herois")
@CrossOrigin(origins = "*")
public class HeroiController {

    private final HeroiService heroiService;

    public HeroiController(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

    // Endpoint GET 1: Listar todos os heróis (Atende ao Requisito)
    @GetMapping
    public ResponseEntity<List<HeroiSaidaDTO>> listarTodos() {
        return ResponseEntity.ok(heroiService.listarTodos());
    }

    // Endpoint GET 2: Buscar herói por ID (Atende ao Requisito)
    @GetMapping("/{id}")
    public ResponseEntity<HeroiSaidaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(heroiService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<HeroiSaidaDTO> criar(@RequestBody @Valid HeroiEntradaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(heroiService.salvar(dto));
    }
}