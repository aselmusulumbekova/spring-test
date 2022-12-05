package kg.megacom.spring.test.controllers;

import kg.megacom.spring.test.models.Positions;
import kg.megacom.spring.test.models.dtos.PositionsDto;
import kg.megacom.spring.test.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/position")
public class PositionControllers {

    @Autowired
    private PositionService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PositionsDto positions) {
        try {
            return ResponseEntity.ok(service.save(positions));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
     @GetMapping("/get")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        }
        catch (Exception e)
            {
                return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
   }

  @GetMapping("/get/all")
   public ResponseEntity finaAll() {
      try {
          return ResponseEntity.ok(service.finaAll());
      } catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
      }
  }
}
