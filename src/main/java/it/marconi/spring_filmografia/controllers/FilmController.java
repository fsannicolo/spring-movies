package it.marconi.spring_filmografia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.spring_filmografia.domains.Film;
import it.marconi.spring_filmografia.domains.FilmForm;
import it.marconi.spring_filmografia.services.FilmService;

@Controller
@RequestMapping("/films")
public class FilmController {
    
    @Autowired
    FilmService filmService;

    @GetMapping(path = {"", "/"})
    public ModelAndView showFilmList() {
        
        List<Film> films = filmService.getFilms();
        return new ModelAndView("film-list").addObject("films", films);
    }

    @GetMapping("/new")
    public ModelAndView handlerNewMovie() {

        return new ModelAndView("film-form").addObject("filmForm", new FilmForm());
    }

    @PostMapping("/addmovie")
    public ModelAndView handlerSaveMovie(@ModelAttribute FilmForm filmForm) {

        Film film = filmService.save(filmForm);
        
        // TODO
        return new ModelAndView("redirect:/films/" + film.getCode());

    } 
}
