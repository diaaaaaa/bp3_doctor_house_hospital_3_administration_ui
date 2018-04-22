package at.refugeescode.accountancy.controller;

import at.refugeescode.accountancy.persistence.model.Invoice;
//import at.refugeescode.accountancy.persistence.repository.InvoiceRepository;
import at.refugeescode.accountancy.persistence.repository.InvoiceRepository;
import at.refugeescode.hospital_admission.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class AccountancyEndpoint {

    private InvoiceRepository invoiceRepository;
    private Patient patientFile;
    private Invoice invoice = new Invoice();
    public AccountancyEndpoint(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/patients")
    Patient getPatientFile() {
        return patientFile;
    }

    @PostMapping("/patients")
    Patient showPatientFile(@RequestBody Patient patient) {
        patientFile = patient;
        invoice.setPatientName(patient.getName());
        invoice.setPatientTreatment(patient.getTreatment());
        invoice.setLocalDateTime(LocalDateTime.now());
        invoice.setCost(10.5);
        invoiceRepository.save(invoice);

        return patientFile;
    }

    @GetMapping("/invoices")
    Invoice getInvoices()  {
        return invoice;
    }
}
