package kg.megacom.spring.test.controllers;

import kg.megacom.spring.test.models.Employee;
import kg.megacom.spring.test.models.dtos.EmployeeDto;
import kg.megacom.spring.test.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empl")
public class EmployeeController {

    @Autowired
    private  EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDto employee)
    {
        try {
            return ResponseEntity.ok(service.save(employee));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
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
