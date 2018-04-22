package at.refugeescode.diagnose_room;

import at.refugeescode.hospital_admission.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import java.util.List;

@RestController
public class DiagnoseRoomEndPoint {

    private Patient patient ;
    private List<Patient> patients = new ArrayList<>();
    private DrHouse drHouse = new DrHouse();



    @PostMapping("/diagnose_room")
    Patient getPatientFromHospitalAdmission(@RequestBody Patient patientFromHospitalAdmission){
        patient = drHouse.findOutIill(patientFromHospitalAdmission);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8083/patients";
        restTemplate.postForEntity(url,patient, Patient.class);
        return  patient;
    }





    @GetMapping("/diagnose_room")
    Patient getPatient(){
        return  patient;
    }
}
