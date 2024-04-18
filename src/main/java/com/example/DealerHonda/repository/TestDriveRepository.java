package com.example.DealerHonda.repository;


import com.example.DealerHonda.entities.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
    Optional<TestDrive> findByIdMotocicletaAndDataAndOraAndLocatie(Long idMotocicleta, LocalDate data, LocalTime ora, String locatie);
    List<TestDrive> findTestDriveByLocatie(String Locatie);
    List<TestDrive> findByIdMotocicleta(Long idMotocicleta);
    List<TestDrive> findByData(LocalDate data);
    List<TestDrive> findByOra(LocalTime ora);
}
