package com.example.service;

import java.util.List;

import com.example.entities.Cliente;
import com.example.entities.Viaje;

public interface IClienteService {
public List<Cliente> getClientes();
public Cliente getCliente(int idCliente);
public void guardar(Cliente cliente);
public void eliminar(int idCliente);
public void modificar(int idCliente,Cliente cliente);
}
