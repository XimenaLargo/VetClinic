package com.vetclinic.VetClinic.Service;

import com.vetclinic.VetClinic.Model.Tutor;
import com.vetclinic.VetClinic.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> getAllTutors(){
        return tutorRepository.findAll();
    }

    public Optional<Tutor> getTutorById(Long id){
        return tutorRepository.findById(id);
    }

    public Tutor createTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public void deleteTutor(Long id){
        tutorRepository.deleteById(id);
    }

    public Tutor updateTutor(Long id, Tutor newTutor){
        return tutorRepository.findById(id).map(tutor -> {
            tutor.setName(newTutor.getName());
            tutor.setNumberDocument(newTutor.getNumberDocument());
            tutor.setPets(newTutor.getPets());
            return tutorRepository.save(tutor);
        }).orElseGet(() -> {
            newTutor.setId(id);
            return tutorRepository.save(newTutor);
        });
    }
}
