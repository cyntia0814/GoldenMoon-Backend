/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.movie.interfaces;


import com.app.movie.entities.Staff;
import org.springframework.data.repository.CrudRepository;


public interface IStaffRepository extends CrudRepository<Staff, String> {

}
