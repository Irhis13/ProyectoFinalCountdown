package com.example.service;

import java.util.List;

import com.example.entities.Cliente;

public interface IClienteService {
public List<Cliente> getClientes();
public Cliente getCliente(long idCliente);
public void guardar(Cliente cliente);
public void eliminar(long idCliente);
public void modificar(long idCliente,Cliente cliente);
}
