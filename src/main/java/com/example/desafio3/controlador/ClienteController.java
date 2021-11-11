/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio3.controlador;

import com.example.desafio3.entidad.Cliente;
import com.example.desafio3.servicio.ClienteServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Manuel
 */
@Controller
public class ClienteController {

    @Autowired
    private ClienteServiceI clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @GetMapping("listaclientes")
    public String mostrarClientes(Model model) {
        var clientes = clienteService.obtenerClientes();

        model.addAttribute("clientes", clientes);

        return "listaclientes";
    }

    //Lleva a la página para rellenar los datos del cliente
    @GetMapping("anadircliente")
    public String anadirCliente(Cliente cliente) {
        return "anadircliente";
    }

    //Cuando pulsa el botón de añadir lo guarda en la base de datos
    @PostMapping("guardarcliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/listaclientes";
    }
    
    //Lleva a la página para introducir el nombre del cliente
    @GetMapping("buscarcliente")
    public String buscarCliente(Cliente cliente) {
        return "buscarcliente";
    }

    //Cuando pulsa el botón de buscar envía la petición para buscarlo
    @PostMapping("buscar")
    public String buscar(Model model, String nombre) {
        var clientes = clienteService.findByNombre(nombre);
        model.addAttribute("clientes", clientes);

        return "listaclientes";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(Cliente cliente) {
        clienteService.eliminar(cliente);
        return "redirect:/listaclientes";
    }

}
