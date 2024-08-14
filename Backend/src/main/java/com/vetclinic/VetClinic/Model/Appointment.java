package com.vetclinic.VetClinic.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "pets_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vets_id")
    private Vet vet;
}
