package org.launchcode.movie_description.controllers;

import org.launchcode.movie_description.models.Movies;
import org.launchcode.movie_description.repository.MoviesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

//    GET http://localhost.8080/api/movies/
//    Todo: get all movies
    @GetMapping
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }


//Todo: add a movie
    @PostMapping("/add")
    public Movies addNewMovie(@RequestBody Movies movie) {
//        temporary description until AI is added
        movie.setDescription("Description is coming soon....");
        return moviesRepository.save(movie);

    }
}
