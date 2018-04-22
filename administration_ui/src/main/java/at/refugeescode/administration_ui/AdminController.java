package at.refugeescode.administration_ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class AdminController {

    private Invoice invoice;

    @GetMapping("/home")
    String mainPage(){

        return "home";
    }

    @GetMapping("/invoices")
    String invoicePage(){

        return "invoices";
    }

    @ModelAttribute("patient")
    Patient createPatient(){
        return new Patient();
    }
    @ModelAttribute("invoice")
    Invoice createInvoice(Invoice invoice){
        RestTemplate restTemplate = new RestTemplate();
        Invoice forObject = restTemplate.getForObject("http://localhost:8084/invoices", Invoice.class);
        invoice.setPatientName(forObject.getPatientName());
        invoice.setPatientTreatment(forObject.getPatientTreatment());
        invoice.setCost(forObject.getCost());
        invoice.setLocalDateTime(forObject.getLocalDateTime());
        return invoice;
    }

    @PostMapping("/addPatient")
    String addPatient(Patient patient){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8081/patients",patient,Patient.class);

        return "home";
    }



}
