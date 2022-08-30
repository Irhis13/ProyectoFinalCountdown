package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IViajeDao;
import com.example.entities.Viaje;

@Service
public class ViajeServiceImpl implements IViajeService{
    
    @Autowired
    private IViajeDao daoViaje;

    @Override
    public List<Viaje> getViajes() {
        
        return daoViaje.findAll();
    }

    @Override
    public Viaje getViaje(int idViaje) {
        return daoViaje.findById(idViaje).get();
        // return null;
    }

    @Override
    public void guardar(Viaje viaje) {
        daoViaje.save(viaje);
        
    }

    @Override
    public void eliminar(int idViaje) {
        daoViaje.deleteById(idViaje);
        
    }

    @Override
    public List<Viaje> getViajesCategoria(int idCategoria) {
        List<Viaje> viajes = daoViaje.findAll();
        List<Viaje> viajesCat = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if(idCategoria== viaje.getCategoria().getId()){
                viajesCat.add(viaje);
            }
        }
        return viajesCat;
    }
}
