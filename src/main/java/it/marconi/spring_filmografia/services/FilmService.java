package it.marconi.spring_filmografia.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.marconi.spring_filmografia.domains.Film;
import it.marconi.spring_filmografia.domains.FilmForm;
import it.marconi.spring_filmografia.repositories.FilmRepository;

@Service
public class FilmService {
    
    @Autowired
    FilmRepository filmRepo;

    public List<Film> getFilms() {
        return filmRepo.findAll();
    }

    public Film save(FilmForm filmForm) {
        Film f = mapFilm(filmForm);
        return filmRepo.save(f);
    }

    private Film mapFilm(FilmForm form) {
        Film f = new Film();
        f.setTitle(form.getTitle());
        f.setGenre(form.getGenre());
        f.setYear(form.getYear());
        f.setRating(form.getRating());

        return f;
    }

    public Optional<Film> get(UUID code) {
        return filmRepo.findById(code);
    }

    // delete

    // delete all

    // filter by name
}
