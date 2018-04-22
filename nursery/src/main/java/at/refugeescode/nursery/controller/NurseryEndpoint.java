package at.refugeescode.nursery.controller;

import at.refugeescode.hospital_admission.Patient;
import at.refugeescode.nursery.persistence.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class NurseryEndpoint {

    private PatientRepository patientRepository;
    HashMap<String,String> hmap = new HashMap<String,String>();

    public NurseryEndpoint(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @PostMapping
    Patient save(@RequestBody Patient patient) {
        patient = giveTreatment(patient);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8084/patients";
        restTemplate.postForEntity(url,patient, Patient.class);
        return patientRepository.save(patient);
    }
    public Patient giveTreatment(Patient patient) {

        hmap.put("cough", "treatment for cough");
        hmap.put("pressure", "treatment for pressure");
        hmap.put("breast cancer", "treatment for breast cancer");
        hmap.put("asthma", "treatment for asthma");
        String treatment = "No treatment for lupus";
        if (hmap.containsKey(patient.getIllness())) {
            treatment = hmap.get(patient.getIllness());
        }
        patient.setTreatment(treatment);
        return patient;

    }

}
