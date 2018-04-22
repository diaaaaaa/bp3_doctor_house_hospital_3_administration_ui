package at.refugeescode.administration_ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class AdminController {

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

    @PostMapping("/addPatient")
    String addPatient(Patient patient){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8081/patients",patient,Patient.class);

        return "home";
    }

}
