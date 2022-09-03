package com.example.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Roles;

@Repository
public interface IRoles extends JpaRepository <Roles, Long> {
    
    Roles findByNombre(String nombre); 
}
