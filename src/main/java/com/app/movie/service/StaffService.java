/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;


import com.app.movie.entities.Staff;
import com.app.movie.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    StaffRepository repository;

    public Iterable<Staff> get() {
        Iterable<Staff> response = repository.getAll();
        return response;
    }

    public Staff create(Staff request) {

        return repository.save(request);

    }

    public Staff update(Staff staff) {
        Staff staffToUpdate = new Staff();

        Optional<Staff> currentStaff = repository.findById(staff.getId());
        if (!currentStaff.isEmpty()) {
            staffToUpdate = staff;
            staffToUpdate=repository.save(staffToUpdate);
        }
        return staffToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}