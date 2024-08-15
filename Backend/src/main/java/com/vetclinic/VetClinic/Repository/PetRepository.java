package com.vetclinic.VetClinic.Repository;

import com.vetclinic.VetClinic.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
