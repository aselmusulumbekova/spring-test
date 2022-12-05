package kg.megacom.spring.test.controllers;

import io.swagger.annotations.Api;
import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.dtos.AccountDto;
import kg.megacom.spring.test.models.dtos.EmployeeDto;
import kg.megacom.spring.test.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/acc")

public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AccountDto account)
    {
        try {
            return ResponseEntity.ok(service.save(account));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
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
