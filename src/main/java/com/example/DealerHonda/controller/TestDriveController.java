package com.example.DealerHonda.controller;

import com.example.DealerHonda.entities.TestDrive;
import com.example.DealerHonda.service.TestDriveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/testdrive")
public class TestDriveController {

    private TestDriveService testDriveService;



    @Autowired
    public TestDriveController(TestDriveService testDriveService) {
        this.testDriveService = testDriveService;
    }

    @PostMapping("/schedule")
    public ResponseEntity<?> scheduleTestDrive(@Valid @RequestBody TestDrive testDrive) {
        return testDriveService.scheduleTestDrive(testDrive);


    }

    @GetMapping()
    public ResponseEntity<?> getTestDrive() {
        return testDriveService.getTestDrive();
    }

    @GetMapping("/locatie/{locatie}")
    public ResponseEntity<?> getTestDriveByLocatie(@PathVariable String locatie) {
        return testDriveService.getTestDriveByLocatie(locatie);
    }
    @GetMapping("/idMotocicleta/{idMotocicleta}")
    public ResponseEntity<?> getTestDriveByIdMotocicleta(@PathVariable Long idMotocicleta) {
        return testDriveService.getTestDriveByIdMotocicleta(idMotocicleta);
    }

    @GetMapping("/data/{data}")
    public ResponseEntity<?> getTestDriveByData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return testDriveService.getTestDriveByData(data);
    }

    @GetMapping("/ora/{ora}")
    public ResponseEntity<?> getTestDriveByOra(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime ora) {
        return testDriveService.getTestDriveByOra(ora);
    }

    //------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestDriveById(@PathVariable Long id) {
        return testDriveService.deleteTestDriveById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestDrive(@PathVariable Long id, @Valid @RequestBody TestDrive updatedTestDrive) {
        return testDriveService.updateTestDrive(id, updatedTestDrive);
    }
}
