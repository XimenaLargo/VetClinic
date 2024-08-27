package com.vetclinic.VetClinic.Repository;

import com.vetclinic.VetClinic.Model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
