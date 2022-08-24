package com.example.service;

import java.util.List;

import com.example.entities.Categoria;

public interface ICategoriaService {
public List<Categoria>getCategorias();    
public void guardar(Categoria categoria);
public Categoria getCategoria (long idCategoria);     
}