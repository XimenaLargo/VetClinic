package com.vetclinic.VetClinic.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tutors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "number_document")
    private Long numberDocument;

    @OneToMany(mappedBy = "tutor")
    @JsonIgnore
    private List<Pet> pets;
}
