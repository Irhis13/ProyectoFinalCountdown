package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ICategoriaDao;
import com.example.entities.Categoria;
import com.example.entities.Viaje;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private ICategoriaDao daoCategoria;

    @Override
    public List<Categoria> getCategorias() {
        return daoCategoria.findAll();
    }

    @Override
    public void guardar(Categoria categoria) {
        daoCategoria.save(categoria);
    }

    @Override
    public Categoria getCategoria(int idCategoria) {
        return daoCategoria.findById(idCategoria).get();
    }

    @Override
    public List<Viaje> getViajesCategoria(int idCategoria) {
        // List<Viaje> prueba = daoViaje.findAll();
        // List<Viaje> viajeCategoria = new ArrayList<>();
        // for (Viaje viaje : prueba) {
        //     if(idCategoria == viaje.getId()){
        //         viajeCategoria.add(viaje);
        //     }
        // }
        // return viajeCategoria;
        return null;
    }
    
}