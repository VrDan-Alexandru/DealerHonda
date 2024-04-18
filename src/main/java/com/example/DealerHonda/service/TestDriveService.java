package com.example.DealerHonda.service;

import com.example.DealerHonda.controller.TestDriveController;
import com.example.DealerHonda.entities.Motocicleta;
import com.example.DealerHonda.entities.TestDrive;
import com.example.DealerHonda.repository.MotocicletaRepository;
import com.example.DealerHonda.repository.TestDriveRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TestDriveService {

    private TestDriveRepository testDriveRepository;
    private MotocicletaRepository motocicletaRepository;

    @Autowired
    public TestDriveService(TestDriveRepository testDriveRepository, MotocicletaRepository motocicletaRepository) {
        this.testDriveRepository = testDriveRepository;
        this.motocicletaRepository = motocicletaRepository;
    }


    public ResponseEntity<?> scheduleTestDrive(TestDrive testDrive) {
        ResponseEntity<?> response = null;
        Optional<TestDrive> optionalTestDrive = testDriveRepository.findByIdMotocicletaAndDataAndOraAndLocatie(testDrive.getIdMotocicleta(), testDrive.getData(), testDrive.getOra(), testDrive.getLocatie());

        if (optionalTestDrive.isPresent()) {
            response = new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            try {
                Optional<Motocicleta> optionalMotocicleta = motocicletaRepository.findById(testDrive.getIdMotocicleta());
                if(optionalMotocicleta.isPresent()){
                    TestDrive insertedTestDrive = testDriveRepository.saveAndFlush(testDrive);
                    response = new ResponseEntity<>(insertedTestDrive, HttpStatus.CREATED);
                }else{
                    response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }

            } catch (Exception e) {

                System.out.println(e.getMessage());
                response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }
        return response;
    }

    public ResponseEntity<?> getTestDrive() {
        ResponseEntity<?> response = null;
        List<TestDrive> testDriveList = testDriveRepository.findAll();

        if (testDriveList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            response = new ResponseEntity<>(testDriveList, HttpStatus.OK);
        }

        return response;
    }
//get by locatie
    public ResponseEntity<?> getTestDriveByLocatie(String locatie) {
        ResponseEntity<?> response = null;
        List<TestDrive> testDriveList = testDriveRepository.findTestDriveByLocatie(locatie);

        if (testDriveList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            response = new ResponseEntity<>(testDriveList, HttpStatus.OK);
        }

        return response;
    }


    //---------------------------------------------------------
//get by id
    public ResponseEntity<?> getTestDriveByIdMotocicleta(Long idMotocicleta) {
        ResponseEntity<?> response = null;
        List<TestDrive> testDriveList = testDriveRepository.findByIdMotocicleta(idMotocicleta);

        if (testDriveList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(testDriveList, HttpStatus.OK);
        }

        return response;
    }
//get by data
    public ResponseEntity<?> getTestDriveByData(LocalDate data) {
        ResponseEntity<?> response = null;
        List<TestDrive> testDriveList = testDriveRepository.findByData(data);

        if (testDriveList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(testDriveList, HttpStatus.OK);
        }

        return response;
    }
//get by ora
    public ResponseEntity<?> getTestDriveByOra(LocalTime ora) {
        ResponseEntity<?> response = null;
        List<TestDrive> testDriveList = testDriveRepository.findByOra(ora);

        if (testDriveList.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(testDriveList, HttpStatus.OK);
        }

        return response;

    }
    //delete test drive
    public ResponseEntity<?> deleteTestDriveById(Long testDriveId) {
        ResponseEntity<?> response;
        try {
            testDriveRepository.deleteById(testDriveId);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException ex) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    // --------------------------------
        //Update pentru test drive
    public ResponseEntity<?> updateTestDrive(@PathVariable Long id, @Valid @RequestBody TestDrive updatedTestDrive) {
        ResponseEntity<?> response = null;
        try {
            Optional<TestDrive> optionalTestDrive = testDriveRepository.findById(id);
            if (optionalTestDrive.isPresent()) {
                TestDrive existingTestDrive = optionalTestDrive.get();
                existingTestDrive.setIdMotocicleta(updatedTestDrive.getIdMotocicleta());
                existingTestDrive.setData(updatedTestDrive.getData());
                existingTestDrive.setOra(updatedTestDrive.getOra());
                existingTestDrive.setLocatie(updatedTestDrive.getLocatie());

                TestDrive savedTestDrive = testDriveRepository.save(existingTestDrive);
                response = new ResponseEntity<>(savedTestDrive, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }



}
