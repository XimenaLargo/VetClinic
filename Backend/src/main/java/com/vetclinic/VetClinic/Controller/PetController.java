package com.vetclinic.VetClinic.Controller;

import com.vetclinic.VetClinic.Model.Pet;
import com.vetclinic.VetClinic.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id){
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id){
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> uptdatePet(@PathVariable Long id, @RequestBody Pet newPet){
        Pet uptdatePet = petService.uptdatePet(id, newPet);
        return ResponseEntity.ok(uptdatePet);
    }
}
