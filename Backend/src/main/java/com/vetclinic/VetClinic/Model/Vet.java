package com.vetclinic.VetClinic.Model;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vet_id")
    private List<Pet> pets;
}
