package com.example.desafio3;

import com.example.desafio3.entidad.Cliente;
import com.example.desafio3.servicio.ClienteServiceI;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner {

    @Autowired
    private ClienteServiceI clienteServiceI;

    public static void main(String[] args) {
        SpringApplication.run(Desafio3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente1 = new Cliente("Paco","López",new Date(1993,11,10), "11111111A");
        Cliente cliente2 = new Cliente("Jose","Pérez",new Date(1997,03,10), "11111111B");
        Cliente cliente3 = new Cliente("Jose","Sánchez",new Date(1999,03,10), "44444444H");
        clienteServiceI.guardar(cliente1);
        clienteServiceI.guardar(cliente2);
        clienteServiceI.guardar(cliente3);
        
        Cliente c = clienteServiceI.findByNombreAndApellidos("Paco", "Lopez");
        System.out.println("Cliente: " + c.getNombre() + " " + c.getApellidos() + " DNI: " + c.getDni());
        
        cliente1.setDni("22222222F");
        clienteServiceI.modificar(cliente1);
    }

}
