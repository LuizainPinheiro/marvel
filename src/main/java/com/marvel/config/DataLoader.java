package com.marvel.config;

import com.marvel.model.Equipe;
import com.marvel.model.Heroi;
import com.marvel.repository.EquipeRepository;
import com.marvel.repository.HeroiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EquipeRepository equipeRepository;
    private final HeroiRepository heroiRepository;

    public DataLoader(EquipeRepository equipeRepository, HeroiRepository heroiRepository) {
        this.equipeRepository = equipeRepository;
        this.heroiRepository = heroiRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Equipe vingadores = new Equipe(null, "Vingadores", "Torre dos Vingadores", null);
        equipeRepository.save(vingadores);

        Heroi homemDeFerro = new Heroi(null, "Homem de Ferro", "Tony Stark", "Tecnologia", "vffg", vingadores);
        heroiRepository.save(homemDeFerro);
    }
}