/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;


import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Movie;
import com.app.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final String MOVIE_REGISTERED="La pelicula ya se encuentra registrada";
    private final String MOVIE_SUCCESS="La pelicula se registró correctamente";


    @Autowired
    MovieRepository repository;

    public Iterable<Movie> get() {
        Iterable<Movie> response = repository.getAll();
        return response;
    }

    public ResponseDto create(Movie request) {
        ResponseDto response = new ResponseDto();
        List<Movie> movies = repository.getByName(request.getName());
        if(movies.size()>0){
            response.status=false;
            response.message=MOVIE_REGISTERED;
        }else{
            repository.save(request);
            response.status=true;
            response.message=MOVIE_SUCCESS;
            response.id= request.getId();
        }
        return response;
    }

    public Movie update(Movie movie) {
        Movie movieToUpdate = new Movie();

        Optional<Movie> currentMovie = repository.findById(movie.getId());
        if (!currentMovie.isEmpty()) {
            movieToUpdate = movie;
            movieToUpdate=repository.save(movieToUpdate);
        }
        return movieToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
    public List<Movie> getMoviePeriod(String d1, String d2) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date fechauno = new Date();
        Date fechados = new Date();
        try {
            fechauno = parser.parse(d1);
            fechados = parser.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (fechauno.before(fechados)) {
            return repository.getMoviePeriod(fechauno, fechados);
        }else{
            return new ArrayList<>();
        }
    }
}