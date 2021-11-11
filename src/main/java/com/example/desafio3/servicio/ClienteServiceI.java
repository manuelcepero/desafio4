/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio3.servicio;

import com.example.desafio3.entidad.Cliente;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface ClienteServiceI {
    void guardar(Cliente cliente);
    void eliminar(Cliente cliente);
    void modificar(Cliente cliente);
    Cliente buscarCliente(Long id);
    List<Cliente> obtenerClientes();
    Cliente findByNombreAndApellidos(String nombre, String apellidos);
    List<Cliente> findByNombre(String nombre);
}