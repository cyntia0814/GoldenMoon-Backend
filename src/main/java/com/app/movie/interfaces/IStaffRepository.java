package com.app.movie.interfaces;


import com.app.movie.entities.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface IStaffRepository extends MongoRepository<Staff, String> {

}
