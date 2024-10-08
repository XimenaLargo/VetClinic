package com.vetclinic.VetClinic.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "number_document")
    private Long numberDocument;

    @OneToMany(mappedBy = "vet")
    @JsonIgnore
    private List<Appointment> appointments;
}
