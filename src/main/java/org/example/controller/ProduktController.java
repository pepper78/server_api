package org.example.controller;


import org.example.model.Produkt;
import org.example.repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class ProduktController {

    @Autowired
    private ProduktRepository repository;

    @GetMapping("/dane")
    public List<Produkt> pobierzWszystkie() {
        return repository.findAll();
    }

    @GetMapping("/produkty/{id}")
    public ResponseEntity<Produkt> pobierzPoId(@PathVariable Long id) {
        return repository.findById(id)
                .map(produkt -> ResponseEntity.ok().body(produkt))
                .orElse(ResponseEntity.notFound().build());
    }
}
