package com.example.DealerHonda.service;

import com.example.DealerHonda.entities.Motocicleta;
import com.example.DealerHonda.repository.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotocicletaService {


    private MotocicletaRepository motocicletaRepository;

    @Autowired
    public MotocicletaService(MotocicletaRepository motocicletaRepository) {
        this.motocicletaRepository = motocicletaRepository;
    }

    public ResponseEntity<?> getMoto() {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findAll();

        if (motoList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            response = new ResponseEntity<>(motoList, HttpStatus.OK);
        }

        return response;
    }

    public ResponseEntity<?> getMotoByCategory(String categorie) {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findMotocicleteByCategorie(categorie);

        if (motoList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            response = new ResponseEntity<>(motoList, HttpStatus.OK);
        }

        return response;
    }

    public ResponseEntity<?> getMotoById(Long id) {
        ResponseEntity<?> response = null;
        Optional<Motocicleta> optionalMotocicleta = motocicletaRepository.findById(id);

        if (optionalMotocicleta.isPresent()) {
            response = new ResponseEntity<>(optionalMotocicleta.get(), HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return response;
    }

    public ResponseEntity<?> addMoto(Motocicleta moto) {
        ResponseEntity<?> response = null;


        try {
            Motocicleta insertedMoto = motocicletaRepository.saveAndFlush(moto);
            response = new ResponseEntity<>(insertedMoto, HttpStatus.CREATED);

        } catch (Exception e) {

            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    public ResponseEntity<?> deleteMotocicleta(Long id) {

        ResponseEntity<?> response = null;

        Optional<Motocicleta> optionalMotocicleta = motocicletaRepository.findById(id);

        if (optionalMotocicleta.isPresent()) {
            motocicletaRepository.delete(optionalMotocicleta.get());
            response = new ResponseEntity<>( HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return response;
    }

    public ResponseEntity<?> updateMoto(Long id, Motocicleta moto) {
        ResponseEntity<?> response = null;
        Optional<Motocicleta> optionalMotocicleta = motocicletaRepository.findById(id);

        if (optionalMotocicleta.isPresent()) {

            moto.setId(id);
            try {

                Motocicleta insertedMoto = motocicletaRepository.saveAndFlush(moto);
                response = new ResponseEntity<>(insertedMoto, HttpStatus.OK);

            } catch (Exception e) {

                response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }


        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }



        return response;
    }

    //----------------------------------------------------------------

    public ResponseEntity<?> getMotoByNume(String nume) {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findMotocicleteByNume(nume);
        response = createResponseForMotoList(motoList);
        return response;
    }

    public ResponseEntity<?> getMotoByCapacitateCilindrica(Integer capacitateCilindrica) {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findMotocicleteByCapacitateCilindrica(capacitateCilindrica);
        response = createResponseForMotoList(motoList);
        return response;
    }

    public ResponseEntity<?> getMotoByCaiPutere(Integer caiPutere) {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findMotocicleteByCaiPutere(caiPutere);
        response = createResponseForMotoList(motoList);
        return response;
    }

    public ResponseEntity<?> getMotoByCategoriePermis(String categoriePermis) {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findMotocicleteByCategoriePermis(categoriePermis);
        response = createResponseForMotoList(motoList);
        return response;
    }

    public ResponseEntity<?> getMotoByPret(Double pret) {
        ResponseEntity<?> response = null;
        List<Motocicleta> motoList = motocicletaRepository.findMotocicleteByPret(pret);
        response = createResponseForMotoList(motoList);
        return response;
    }

    private ResponseEntity<?> createResponseForMotoList(List<Motocicleta> motoList) {
        ResponseEntity<?> response;
        if (motoList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(motoList, HttpStatus.OK);
        }
        return response;
    }
}
