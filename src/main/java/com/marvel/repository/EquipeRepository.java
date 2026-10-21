package com.marvel.repository;

import com.marvel.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Optional<Equipe> findByNomeContainingIgnoreCase(String nome);
}