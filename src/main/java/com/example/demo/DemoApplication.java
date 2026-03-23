// organización del proyecto
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Inicia todo el framework de Spring para que la app esté lista para recibir peticiones.
		SpringApplication.run(DemoApplication.class, args);
	}

}
