package com.example.DealerHonda.repository;

import com.example.DealerHonda.entities.Motocicleta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotocicletaRepository extends JpaRepository<Motocicleta, Long> {

    List<Motocicleta> findMotocicleteByCategorie(String categorie);

    List<Motocicleta> findMotocicleteByNume(String nume);

    List<Motocicleta> findMotocicleteByCapacitateCilindrica(Integer capacitateCilindrica);

    List<Motocicleta> findMotocicleteByCaiPutere(Integer caiPutere);

    List<Motocicleta> findMotocicleteByCategoriePermis(String categoriePermis);

    List<Motocicleta> findMotocicleteByPret(Double pret);
}
