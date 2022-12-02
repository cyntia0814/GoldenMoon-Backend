/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.controller;


import com.app.movie.entities.Staff;
import com.app.movie.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    StaffService service;

    @GetMapping("")
    public Iterable<Staff> get() {
        return service.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Staff create(@RequestBody Staff request) {
        return service.create(request);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Staff update(@RequestBody Staff request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}