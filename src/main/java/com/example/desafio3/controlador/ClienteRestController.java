/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio3.controlador;

import com.example.desafio3.entidad.Cliente;
import com.example.desafio3.servicio.ClienteServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manuel
 */
@RestController
@RequestMapping("/api")
public class ClienteRestController {
    
    @Autowired
    private ClienteServiceI clienteService;
    
    @GetMapping(value = "/{id}")
    public Cliente getClientebyId(final @PathVariable Long id){
        Cliente c = clienteService.buscarCliente(id);
        return c;
    }
    
    @PostMapping()
    public void anadirCliente(@RequestBody Cliente cliente){
        clienteService.guardar(cliente);
    }
    
}
