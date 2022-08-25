package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Empleado;

@Repository
public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {
    
}
