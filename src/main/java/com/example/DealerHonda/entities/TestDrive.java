package com.example.DealerHonda.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "test_drive")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idMotocicleta;
    @NotNull
    private LocalDate data;
    @NotNull
    private LocalTime ora;
    @NotNull
    private String locatie;

    public TestDrive() {
    }

    public TestDrive(Long id, Long idMotocicleta, LocalDate data, LocalTime ora, String locatie) {
        this.id = id;
        this.idMotocicleta = idMotocicleta;
        this.data = data;
        this.ora = ora;
        this.locatie = locatie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMotocicleta() {
        return idMotocicleta;
    }

    public void setIdMotocicleta(Long idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
}
