package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IClienteDao;
import com.example.entities.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao daoCliente;

    @Override
    public List<Cliente> getClientes() {
        return daoCliente.findAll();
    }
        

    @Override
    public Cliente getCliente(long idCliente) {
        //REPASARRR
        return daoCliente.findById(idCliente).get();
        // return null;
    }

    @Override
    public void guardar(Cliente cliente) {
        //Nuevo cliente
        daoCliente.save(cliente);
        
    }

    @Override
    public void eliminar(long idCliente) {
        daoCliente.deleteById(idCliente);
        
    }

    @Override
    public void modificar(long idCliente,Cliente cliente) {
        //Que seleccione el cliente, no que lo introduzca con un combobox
        Cliente clienteDB = daoCliente.findById(idCliente).get();
        clienteDB.setNombre(cliente.getNombre());
        clienteDB.setApellidos(cliente.getApellidos());
        clienteDB.setImagenDni(cliente.getImagenDni());
        clienteDB.setFechaSalida(cliente.getFechaSalida());
        clienteDB.setFechaRegreso(cliente.getFechaRegreso());
        clienteDB.setTelefono(cliente.getTelefono());
        clienteDB.setEmail(cliente.getEmail());
        clienteDB.setViaje(cliente.getViaje());

        daoCliente.save(cliente);        
    }
    
}