package kg.megacom.spring.test.controllers;

import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.Employee;
import kg.megacom.spring.test.models.Phone;
import kg.megacom.spring.test.models.dtos.AccountDto;
import kg.megacom.spring.test.models.dtos.PhoneDto;
import kg.megacom.spring.test.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phone")
public class PhoneController {

   @Autowired
    private PhoneService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PhoneDto phone)
    {
        try {
            return ResponseEntity.ok(service.save(phone));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
   @GetMapping("/get")
   public ResponseEntity<?> findById(@RequestParam Long id) {
       try {
           return ResponseEntity.ok( service.findById(id));
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
       }
   }


    @GetMapping("/get/all")
    public ResponseEntity<?> finAll() {
        try {
            return ResponseEntity.ok( service.finaAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
