package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ogretmen;
import com.garanti.FirstSpringWeb.repo.OgretmenRepo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bu anotasyonlar class'ların başına yazılır ve bu class'ın
 * bean yapılarak hafızaya atılmasını sağlar.
 * @Controller
 * @RestController
 * @Component
 * @Configuration
 * @Service
 * @Repository
 *
 * import org.springframework.stereotype; sınıfından gelir.
 */

// localhost:9090/FirstSpringWeb/ogretmen
@RestController
@RequestMapping(path = "ogretmen")
public class OgretmenController
{
    /**
     * OgretmenRepo sınıfının başına @Repository yazdık.
     * @Autowired biz OgretmenRepo'yu new yapmayalım diye @Repository ile buluyor
     * ve new yapıyor.
     */
    // Dependency injection
//    @Autowired // required özelliğini dene iki repodan autowired almaya çalışsın mesela
    private OgretmenRepo repo;

    public OgretmenController(OgretmenRepo repo)
    {
        // @Autowired yerine bu şekilde constructor injection yapılabilir.
        // this.repo = new OgretmenRepo(); // yazmak yerine dışardan yani app context ten geliyor
        // Bu kullanımda OgretmenRepo private olmalı.
        this.repo = repo;
    }

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List< Ogretmen >> getAll()
    {
        // localhost:9090/FirstSpringWeb/ogretmen/getAll
        List<Ogretmen> res = repo.getAll();
        if ( res == null ||res.size() == 0 ) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping(path = "findAllByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ogretmen>> getByIdQueryParam(@RequestParam(value = "name", required = true) String name)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/findAllByName?name=a
        return ResponseEntity.ok(this.repo.getAllLike(name));
    }

    @GetMapping(path = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogretmen> getByIdHeader(@RequestHeader (name = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/getById?id=1
        Ogretmen res = repo.getById(id);
        if ( res != null ) {
            return ResponseEntity.ok(res);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogretmen> getByIdQueryParam(@RequestParam (value = "id", required = true) Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/getById?id=1
        Ogretmen res = repo.getById(id);
        if ( res != null ) {
            return ResponseEntity.ok(res);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogretmen> getByIdPathParam(@PathVariable(value = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/getById/1
        //bütün parametreleri vermek zorundayız
        //consume restful servisin dışardan alacağı data türünü belirtir
        //produce web servisin dışarıya vereceği türü belirtir
        Ogretmen res = repo.getById(id);
        if ( res != null ) {
            return ResponseEntity.ok(res);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Ogretmen ogretmen)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/save
        // {"name":"RestTest", "is_GICIK": true}
        if (repo.save(ogretmen))
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(ogretmen.getNAME() + " isimli öğretmen başarıyla eklendi");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ogretmen.getNAME() + " isimli öğretmen eklenemedi");
        }
    }

    // delete metodunda 403 forbidden nasıl çalışır

    @DeleteMapping(path = "deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/deleteById/1
        if (repo.deleteById(id))
        {
            return ResponseEntity.ok("Başarı ile silindi");
        }
        else
        {
            return ResponseEntity.internalServerError().body("Başarı ile silinemedi");
        }
    }

    @DeleteMapping(path = "deleteByIdHeader")
    public ResponseEntity<String> deleteByIdHeader(@RequestHeader(value = "id") Integer id)
    {
        // localhost:9090/FirstSpringWeb/ogretmen/deleteById/1
        if (repo.deleteById(id))
        {
            return ResponseEntity.ok("Başarı ile silindi");
        }
        else
        {
            return ResponseEntity.internalServerError().body("Başarı ile silinemedi");
        }
    }

    @PostMapping(path = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody Ogretmen ogretmen) {
//        localhost:9090/FirstSpringWeb/ogretmen/update
//        {"id":16, "name": "Mahmut"}
        if (repo.update(ogretmen))
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(ogretmen.getNAME() + " isimli öğretmen başarıyla güncellendi");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ogretmen.getNAME() + " isimli öğretmen güncellenemedi");
        }
    }
}
