package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.BusinessException;
import com.garanti.FirstSpringWeb.model.Ogrenci;
import com.garanti.FirstSpringWeb.model.Ogretmen;
import com.garanti.FirstSpringWeb.repo.OgrenciRepo;
import com.garanti.FirstSpringWeb.repo.OgretmenRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "ogrenci")
public class OgrenciController
{
    private OgrenciRepo repo;

    public OgrenciController(OgrenciRepo repo) {
        this.repo = repo;
    }

    @GetMapping (path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< List< Ogrenci > > getAll()
    {
        // localhost:9090/FirstSpringWeb/ogrenci/getAll
        List< Ogrenci > res = repo.getAll();
        /*if ( res.size() == 0 ) {
            throw new BusinessException("My Exception");
        }*/
        if ( res == null || res.size() == 0 ) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping(path = "findAllByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ogrenci>> getByIdQueryParam(@RequestParam(value = "name", required = true) String name)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/findAllByName?name=a
        return ResponseEntity.ok(this.repo.getAllLike(name));
    }

    @GetMapping(path = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogrenci> getByIdHeader(@RequestHeader (name = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/getById?id=1
        Ogrenci res = repo.getById(id);
        if ( res != null ) {
            return ResponseEntity.ok(res);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogrenci> getByIdQueryParam(@RequestParam (value = "id", required = true) Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/getById?id=1
        Ogrenci res = repo.getById(id);
        if ( res != null ) {
            return ResponseEntity.ok(res);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogrenci> getByIdPathParam(@PathVariable(value = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/getById/1
        //b??t??n parametreleri vermek zorunday??z
        //consume restful servisin d????ardan alaca???? data t??r??n?? belirtir
        //produce web servisin d????ar??ya verece??i t??r?? belirtir
        Ogrenci res = repo.getById(id);
        if ( res != null ) {
            return ResponseEntity.ok(res);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Ogrenci ogrenci)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/save
        // {"name":"RestTest", "is_GICIK": true}
        if (repo.save(ogrenci))
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Ba??ar?? ile kaydedildi");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ba??ar?? ile kaydedildi");
        }
    }

    @DeleteMapping(path = "deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/deleteById/1
        if (repo.deleteById(id))
        {
            return ResponseEntity.ok("Ba??ar?? ile silindi");
        }
        else
        {
            return ResponseEntity.internalServerError().body("Ba??ar?? ile silinemedi");
        }
    }

    @DeleteMapping(path = "deleteByIdHeader")
    public ResponseEntity<String> deleteByIdHeader(@RequestHeader(value = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogrenci/deleteById/1
        if (repo.deleteById(id))
        {
            return ResponseEntity.ok("Ba??ar?? ile silindi");
        }
        else
        {
            return ResponseEntity.internalServerError().body("Ba??ar?? ile silinemedi");
        }
    }

    @PostMapping(path = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody Ogrenci ogrenci) {
//        localhost:9090/FirstSpringWeb/ogrenci/update
//        {"id":16, "name": "Mahmut"}
        if (repo.update(ogrenci))
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(ogrenci.getNAME() + " isimli ????renci ba??ar??yla g??ncellendi");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ogrenci.getNAME() + " isimli ????renci g??ncellenemedi");
        }
    }
}
