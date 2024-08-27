package com.vetclinic.VetClinic.Controller;

import com.vetclinic.VetClinic.Model.Vet;
import com.vetclinic.VetClinic.Service.VetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vets")
public class VetController {

    @Autowired
    private VetService vetService;

    @GetMapping
    public List<Vet> getAllVet(){
        return vetService.getAllVet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vet> getVetById(@PathVariable Long id){
        Optional<Vet> vet = vetService.getVetById(id);

        return vet.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vet createVet(@RequestBody Vet newVet){
        return vetService.createVet(newVet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVet(@PathVariable Long id){
        vetService.deleteVet(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vet> updateVet(@RequestBody Vet newVet, @PathVariable Long id){
        Vet updateVet = vetService.updateVet(newVet, id);
        return ResponseEntity.ok(updateVet);
    }
}
