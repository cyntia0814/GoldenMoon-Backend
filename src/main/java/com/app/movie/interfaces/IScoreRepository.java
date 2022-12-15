package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import com.app.movie.entities.Movie;
import com.app.movie.entities.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IScoreRepository extends MongoRepository<Score, String> {
    @Query(value= "{movie.id : ?0,client.id:?1}")
    Iterable<Score> getScoreByMovieAndClient(String movieId,String clientId);

}