package com.example.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.User;

@Repository
public interface IUser extends JpaRepository <User, Long>{
    
    User findByNombre (String usernombre);

    
    
}
