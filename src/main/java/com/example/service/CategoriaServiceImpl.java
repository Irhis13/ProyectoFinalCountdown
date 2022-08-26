package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ICategoriaDao;
import com.example.entities.Categoria;

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
        //Creación categorias
        daoCategoria.save(categoria);
        
    }

    @Override
    public Categoria getCategoria(long idCategoria) {
        //Repasar porqué no funciona
        return daoCategoria.findById(idCategoria).get();
        // return null;
    }
    
}