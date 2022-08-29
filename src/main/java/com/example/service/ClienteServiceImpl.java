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
        //return daoCliente.findById(idCliente).get();
        return null;
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
    public void modificar(Cliente cliente) {
        //REPASAR CÓMO LO HACÍAMOS E IMPLEMENTAR
        
    }
    
}
