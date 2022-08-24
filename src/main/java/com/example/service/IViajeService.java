package com.example.service;

import java.util.List;

import com.example.entities.Viaje;

public interface IViajeService {
    public List<Viaje> getViajes();

    public Viaje getViaje(long idViaje);

    public void guardar(Viaje viaje);

    public void eliminar(long idViaje);
}