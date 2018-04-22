package at.refugeescode.hospital_admission;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HospitalAdmissionEndPoint {

    private Patient patient ;
    private List<Patient> patients = new ArrayList<>();
    private long i = 1;

    @GetMapping("/patients")
    String getPatient(){

        return  patients.toString();
    }

    @PostMapping("/patients")
    void receivePatientFromOutAndSendToDiagnoseRoom(@RequestBody Patient patientFromOutside){

        patientFromOutside.setId(i);
        patient = patientFromOutside ;
        i++;
        patients.add(patient);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/diagnose_room";
        for (Patient p: patients) {
            restTemplate.postForEntity(url,p, Patient.class);
        }

    }
}
