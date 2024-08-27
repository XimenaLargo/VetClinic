package com.vetclinic.VetClinic.Repository;

import com.vetclinic.VetClinic.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
