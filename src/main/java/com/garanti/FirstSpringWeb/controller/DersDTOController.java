package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.DersDTO;
import com.garanti.FirstSpringWeb.model.Ogrenci;
import com.garanti.FirstSpringWeb.repo.DersDTORepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "dersdto")
public class DersDTOController
{
    private DersDTORepo repo;

    public DersDTOController() {
        this.repo = new DersDTORepo();
    }

    /*@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< ArrayList< DersDTO > > getAll() {
        // localhost:9090/FirstSpringWeb/dersdto/getAll
        ArrayList<DersDTO> res = repo.getAll();
        if ( res == null ||res.size() == 0 ) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.ok(res);
        }
    }*/

    /*@PostMapping (path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody DersDTO dersDTO)
    {
        // localhost:9090/FirstSpringWeb/dersdto/save
        if (repo.save(dersDTO))
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Başarı ile kaydedildi");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Başarı ile kaydedildi");
        }
    }*/
}
