package com.vetclinic.VetClinic.Service;

import com.vetclinic.VetClinic.Model.Pet;
import com.vetclinic.VetClinic.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id){
        return petRepository.findById(id);
    }

    public Pet createPet(Pet pet){
        return petRepository.save(pet);
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    public Pet uptdatePet(Long id, Pet newPet){
        return petRepository.findById(id).map(pet -> {
            pet.setName(newPet.getName());
            pet.setAge(newPet.getAge());
            pet.setTutor(newPet.getTutor());
            pet.setAppointments(newPet.getAppointments());
            return petRepository.save(pet);
        }).orElseGet(() -> {
            newPet.setId(id);
            return petRepository.save(newPet);
        });
    }
}
