package com.example.service;

import java.util.List;

import com.example.entities.Empleado;

public interface IEmpleadoService {

    public List<Empleado> getEmpleados();
    public Empleado getEmpleado(int idEmpleado);
    public void guardar(Empleado empleado);
    public void eliminar(int idEmpleado);
    public void modificar(int idEmpleado, Empleado empleado);
    
}