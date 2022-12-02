/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Movie;
import com.app.movie.entities.Staff;
import com.app.movie.interfaces.IMovieRepository;
import com.app.movie.interfaces.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StaffRepository {
    
    @Autowired
    IStaffRepository repository;
    
    public Iterable<Staff> getAll(){
        return repository.findAll();
    }
    
    public Optional<Staff> findById(String id){
        Optional<Staff> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Staff save(Staff staff){
        return repository.save(staff);
    }
    
}
