package org.launchcode.movie_description.repository;

import org.launchcode.movie_description.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
}