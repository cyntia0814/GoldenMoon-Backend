package com.app.movie.interfaces;

import com.app.movie.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface IMovieRepository extends MongoRepository<Movie, String> {
    public List<Movie>findAllByReleaseDateAfterAndReleaseDateBefore(Date fechauno, Date fechados);

    @Query(value= "{name : ?0}")
    List<Movie> getMoviesByName(String name);
}
