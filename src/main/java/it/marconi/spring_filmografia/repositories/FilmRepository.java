package it.marconi.spring_filmografia.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import it.marconi.spring_filmografia.domains.Film;

public interface FilmRepository extends JpaRepository<Film, UUID> {

    
} 
