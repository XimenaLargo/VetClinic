package com.vetclinic.VetClinic.Controller;

import com.vetclinic.VetClinic.Model.Tutor;
import com.vetclinic.VetClinic.Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public List<Tutor> getAllTutors(){
        return tutorService.getAllTutors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id){
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tutor createTutor(@RequestBody Tutor tutor){
        return tutorService.createTutor(tutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id){
        tutorService.deleteTutor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor newTutor){
        Tutor updateTutor = tutorService.updateTutor(id, newTutor);
        return ResponseEntity.ok(updateTutor);
    }
}
