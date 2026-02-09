package org.launchcode.movie_description.controllers;

import org.apache.http.HttpException;
import org.launchcode.movie_description.models.Movie;
import org.launchcode.movie_description.repository.MoviesRepository;
import org.launchcode.movie_description.services.GeminiService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MoviesRepository moviesRepository;

    private final GeminiService geminiService;

    public MoviesController(MoviesRepository moviesRepository, GeminiService geminiService) {
        this.moviesRepository = moviesRepository;
        this.geminiService = geminiService;
    }

//    // GET http://localhost:8080/api/movies/
//    Todo: get all movies
    @GetMapping("")
    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        return moviesRepository.findById(movieId).orElse(null);
    }

//Todo: add a movie
    @PostMapping
    public Movie addNewMovie(@RequestBody Movie movie) throws HttpException, IOException {
        String description = geminiService.generateMovieDescription(movie.getTitle());
        movie.setDescription(description);
        return moviesRepository.save(movie);

    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieById(@PathVariable int movieId) {
        moviesRepository.deleteById(movieId);
    }
}
