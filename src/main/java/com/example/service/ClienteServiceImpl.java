package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IClienteDao;
// import com.example.dao.IViajeDao;
import com.example.entities.Cliente;
import com.example.entities.Viaje;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao daoCliente;

    // @Autowired
    // private IViajeDao daoViaje;

    @Override
    public List<Cliente> getClientes() {
        return daoCliente.findAll();
    }

    List<Viaje> listaViajes = new ArrayList<>();

    @Override
    public Cliente getCliente(int idCliente) {
        // REPASARRR
        return daoCliente.findById(idCliente).get();
        // return null;
    }

    @Override
    public void guardar(Cliente cliente) {
        // Nuevo cliente
        daoCliente.save(cliente);

    }

    @Override
    public void eliminar(int idCliente) {
        daoCliente.deleteById(idCliente);

    }

    @Override
    public void modificar(int idCliente, Cliente cliente) {
        // Que seleccione el cliente, no que lo introduzca con un combobox
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