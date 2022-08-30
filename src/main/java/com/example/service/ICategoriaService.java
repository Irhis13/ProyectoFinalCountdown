package com.example.service;

import java.util.List;

import com.example.entities.Categoria;
import com.example.entities.Viaje;

public interface ICategoriaService {
public List<Categoria>getCategorias();    
public void guardar(Categoria categoria);
public Categoria getCategoria (int idCategoria);
public List<Viaje> getViajesCategoria(int idCategoria);     
}