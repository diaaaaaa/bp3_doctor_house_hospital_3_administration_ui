package at.refugeescode.diagnose_room;

import at.refugeescode.hospital_admission.Patient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class DrHouse {

    HashMap<String,String> hmap = new HashMap<String,String>();
    Patient patientAfterDiagnose;

    public DrHouse() {
    }

    public Patient findOutIill(Patient patientAfterDiagnose) {

        hmap.put("headache", "cough");
        hmap.put("heart attack", "pressure");
        hmap.put("Inverted nipples", "breast cancer");
        hmap.put("Difficulty breathing", "asthma");
        String illness = "lupus";
        if (hmap.containsKey(patientAfterDiagnose.getSymptom())) {
            illness = hmap.get(patientAfterDiagnose.getSymptom());
        }
        patientAfterDiagnose.setIllness(illness);
        return patientAfterDiagnose;

    }

}
