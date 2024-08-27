package com.vetclinic.VetClinic.Service;

import com.vetclinic.VetClinic.Model.Vet;
import com.vetclinic.VetClinic.Repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetService {
    @Autowired
    private VetRepository vetRepository;

    public List<Vet> getAllVet(){
        return vetRepository.findAll();
    }

    public Optional<Vet> getVetById(Long id){
        return vetRepository.findById(id);
    }

    public Vet createVet(Vet newVet){
        return vetRepository.save(newVet);
    }

    public void deleteVet(Long id){
        vetRepository.deleteById(id);
    }

    public Vet updateVet(Vet updateVet, Long id){
        return vetRepository.findById(id).map(vet -> {
            vet.setName(updateVet.getName());
            vet.setNumberDocument(updateVet.getNumberDocument());
            vet.setAppointments(updateVet.getAppointments());

            return vetRepository.save(vet);
        }).orElseGet(() -> {
            updateVet.setId(id);

            return vetRepository.save(updateVet);
        });
    }
}
