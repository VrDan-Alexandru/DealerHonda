package com.example.DealerHonda.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "motociclete")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Motocicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String categorie;
    @NotNull
    private String nume;
    @NotNull
    private Integer capacitateCilindrica;
    @NotNull
    private Integer caiPutere;
    @NotNull
    private String categoriePermis;
    @NotNull
    private Double pret;

    public Motocicleta() {
    }

    public Motocicleta(Long id, String categorie, String nume, Integer capacitateCilindrica, Integer caiPutere, String categoriePermis, Double pret) {
        this.id = id;
        this.categorie = categorie;
        this.nume = nume;
        this.capacitateCilindrica = capacitateCilindrica;
        this.caiPutere = caiPutere;
        this.categoriePermis = categoriePermis;
        this.pret = pret;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public void setCapacitateCilindrica(Integer capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public Integer getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(Integer caiPutere) {
        this.caiPutere = caiPutere;
    }

    public String getCategoriePermis() {
        return categoriePermis;
    }

    public void setCategoriePermis(String categoriePermis) {
        this.categoriePermis = categoriePermis;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }
}
