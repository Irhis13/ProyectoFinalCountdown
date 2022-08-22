package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Categoria;

@Repository
public interface ICategoriaDao extends JpaRepository<Categoria, Integer> {
    
}
