package com.app.movie.controller;

import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Movie;
import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    MovieService service;

    @GetMapping("")
    public Iterable<Movie> get() {
        return service.get();
    }
    @GetMapping("/{id}")
    public Optional<Movie> getById(@PathVariable("id") String id) {
        return service.getById(id);
    }
    @PostMapping("")
    public ResponseEntity<ResponseDto> create(@RequestBody Movie request) {
        ResponseDto responseDto = service.create(request);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);

        if(responseDto.status.booleanValue()==true){
            response = new ResponseEntity<>(responseDto,HttpStatus.CREATED);
        }

        return response;
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie update(@RequestBody Movie request) {
        return service.update(request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
    @GetMapping("/report-dates/{fechauno}/{fechados}")
    public List<Movie> getReleaseDate(@PathVariable("fechauno") String d1, @PathVariable("fechados") String d2){
        return service.getMoviePeriod(d1,d2);
    }

}