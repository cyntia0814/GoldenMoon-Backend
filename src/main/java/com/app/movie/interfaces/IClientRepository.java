package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface IClientRepository extends MongoRepository<Client, String> {
    @Query(value= "{email : ?0}")
    Optional<Client> findByEmail(String email);
    
}
