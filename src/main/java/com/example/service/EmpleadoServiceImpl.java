package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IEmpleadoDao;
import com.example.entities.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoDao daoEmpleado;

    @Override
    public List<Empleado> getEmpleados() {
        return daoEmpleado.findAll();
    }

    @Override
    public Empleado getEmpleado(long idEmpleado) {
        return daoEmpleado.findById(idEmpleado).get();
    }

    @Override
    public void guardar(Empleado empleado) {
        daoEmpleado.save(empleado);

    }

    @Override
    public void eliminar(long idEmpleado) {
        daoEmpleado.deleteById(idEmpleado);

    }

    @Override
    public void modificar(long idEmpleado, Empleado empleado) {

        Empleado empleadoDB = daoEmpleado.findById(idEmpleado).get();

        empleadoDB.setNombre(empleado.getNombre());
        empleadoDB.setDireccion(empleado.getDireccion());
        empleadoDB.setTelefono(empleado.getTelefono());
    }

}