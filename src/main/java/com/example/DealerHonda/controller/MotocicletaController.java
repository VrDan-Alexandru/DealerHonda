package com.example.DealerHonda.controller;

import com.example.DealerHonda.entities.Motocicleta;
import com.example.DealerHonda.service.MotocicletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MotocicletaController {

    private MotocicletaService motocicletaService;

    @Autowired
    public MotocicletaController(MotocicletaService motocicletaService) {
        this.motocicletaService = motocicletaService;
    }

    @GetMapping("/motociclete")
    public ResponseEntity<?> getMoto() {
        return motocicletaService.getMoto();
    }

    @GetMapping("/motociclete/{id}")
    public ResponseEntity<?> getMotoById(@PathVariable Long id) {
        return motocicletaService.getMotoById(id);
    }

    @GetMapping("/motociclete/nume/{nume}")
    public ResponseEntity<?> getMotoByNume(@PathVariable String nume) {
        return motocicletaService.getMotoByNume(nume);
    }

    @GetMapping("/motociclete/capacitateCilindrica/{capacitateCilindrica}")
    public ResponseEntity<?> getMotoByCapacitateCilindrica(@PathVariable Integer capacitate) {
        return motocicletaService.getMotoByCapacitateCilindrica(capacitate);
    }

    @GetMapping("/motociclete/caiPutere/{caiPutere}")
    public ResponseEntity<?> getMotoByCaiPutere(@PathVariable Integer caiPutere) {
        return motocicletaService.getMotoByCaiPutere(caiPutere);
    }

    @GetMapping("/motociclete/categoriePermis/{categoriePermis}")
    public ResponseEntity<?> getMotoByCategoriePermis(@PathVariable String categoriePermis) {
        return motocicletaService.getMotoByCategoriePermis(categoriePermis);
    }

    @GetMapping("/motociclete/pret/{pret}")
    public ResponseEntity<?> getMotoByPret(@PathVariable Double pret) {
        return motocicletaService.getMotoByPret(pret);
    }



    //--------------------------------------------------------------------------------------------

    @PostMapping("/motociclete")
    public ResponseEntity<?> addMoto(@Valid @RequestBody Motocicleta moto) {
        return motocicletaService.addMoto(moto);
    }

    @PutMapping("/motociclete/{id}")
    public ResponseEntity<?> updateMoto(@PathVariable Long id, @Valid @RequestBody Motocicleta moto) {
        return motocicletaService.updateMoto(id, moto);
    }

    @GetMapping("/motociclete/categorie")
    public ResponseEntity<?> getMotoByCategory(@RequestParam String categorie) {
        return motocicletaService.getMotoByCategory(categorie);
    }

    @DeleteMapping("/motociclete/{id}")
    public ResponseEntity<?> deleteMotocicleta(@PathVariable Long id) {
        return motocicletaService.deleteMotocicleta(id);
    }



}
