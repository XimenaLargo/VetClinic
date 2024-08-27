package com.vetclinic.VetClinic.Service;

import com.vetclinic.VetClinic.Model.Appointment;
import com.vetclinic.VetClinic.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    public Appointment uptdateAppointment(Long id, Appointment newAppointment){
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setAppointmentDate(newAppointment.getAppointmentDate());
            appointment.setPet(newAppointment.getPet());
            appointment.setVet(newAppointment.getVet());
            return appointmentRepository.save(appointment);
        }).orElseGet(() -> {
            newAppointment.setId(id);
            return appointmentRepository.save(newAppointment);
        });
    }

}
