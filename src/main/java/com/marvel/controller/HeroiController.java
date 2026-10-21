package com.marvel.controller;

import com.marvel.dtos.HeroiSaidaDTO;
import com.marvel.service.HeroiService;
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

    @GetMapping
    public List<HeroiSaidaDTO> listarTodos() {
        return heroiService.listarTodos();
    }

    @GetMapping("/{id}")
    public HeroiSaidaDTO buscarPorId(@PathVariable Long id) {
        return heroiService.buscarPorId(id);
    }
}