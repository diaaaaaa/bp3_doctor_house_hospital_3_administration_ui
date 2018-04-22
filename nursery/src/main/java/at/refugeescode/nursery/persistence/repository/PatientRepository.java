package at.refugeescode.nursery.persistence.repository;


import at.refugeescode.hospital_admission.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, Long> {


}
