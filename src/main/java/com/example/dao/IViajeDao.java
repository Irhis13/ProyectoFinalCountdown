package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Viaje;

@Repository
public interface IViajeDao extends JpaRepository<Viaje, Integer>{
    
}
