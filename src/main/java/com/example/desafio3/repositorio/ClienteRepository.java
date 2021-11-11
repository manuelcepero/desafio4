/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio3.repositorio;

import com.example.desafio3.entidad.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manuel
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findByNombreAndApellidos(String nombre, String apellidos);
    List<Cliente> findByNombre(String nombre);
}
