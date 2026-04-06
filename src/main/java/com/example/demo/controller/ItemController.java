package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", repository.findAll());
        // Si no hay un item en proceso de edición, enviamos uno nuevo
        if (!model.containsAttribute("item")) {
            model.addAttribute("item", new Item());
        }
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Item item) {
        repository.save(item); // Si el item tiene ID, actualiza; si no, crea.
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Item item = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID invalido"));
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", item); // Pasamos el item con sus datos al formulario
        return "index";
    }
}