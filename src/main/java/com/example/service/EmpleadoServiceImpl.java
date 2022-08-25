package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IEmpleadoDao;
import com.example.entities.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    
    // Inyectamos el daoEmpleado para poder instanciar.
    @Autowired
    private IEmpleadoDao daoEmpleado;


    // Método para devolver lista de empleados.
    @Override
    public List<Empleado> getEmpleados() {
        return daoEmpleado.findAll();
    }

    /**  Este método (findById) devuelve un opcional de empleado (java 11), con este tipo
    de método no es necesario generar manualmente la excepción, ya que se genera
    automáticamente con el opcional. En caso de no usar este tipo de método en el
    caso de que el id de empleado no existiera se generaba un error nullpointerexception 
    por lo que había que general manualmente la excepción con tryCatch.
     */
    @Override
    public Empleado getEmpleado(long idEmpleado) {
        return daoEmpleado.findById(idEmpleado).get();
    }

    @Override
    public void guardar(Empleado empleado) {
        daoEmpleado.save(empleado);
    }

    @Override
    public void borrar(long idEmpleado) {
        daoEmpleado.deleteById(idEmpleado);
    }
    
}
