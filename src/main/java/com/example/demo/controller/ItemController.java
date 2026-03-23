package com.example.demo.controller;
// Importamos el modelo (datos) y el repositorio (base de datos)
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// Indica que esta clase maneja peticiones HTTP y devuelve un archivo HTML
@Controller
public class ItemController {
    // Spring busca una instancia de ItemRepository y la conecta
    @Autowired
    private ItemRepository repository;
    // Responde cuando el usuario entra al index
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new Item());
        return "index";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Item item) {
        repository.save(item);
        // Redirige de nuevo a la ruta principal para ver la lista actualizada
        return "redirect:/";
    }
}