package com.example.service;

import java.util.List;

import com.example.entities.Empleado;

public interface IEmpleadoService {
    
    public List<Empleado> getEmpleados();
    public Empleado getEmpleado(long idEmpleado);
    public void guardar(Empleado empleado);
    public void borrar(long idEmpleado);
}
