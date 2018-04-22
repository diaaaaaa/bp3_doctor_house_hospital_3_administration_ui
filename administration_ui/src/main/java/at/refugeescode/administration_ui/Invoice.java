package at.refugeescode.administration_ui;

import java.time.LocalDateTime;

public class Invoice {
    private Long id;

    private String patientName;

    private String patientTreatment;

    private Double cost;

    private LocalDateTime localDateTime;



    public Invoice() {
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientTreatment() {
        return patientTreatment;
    }

    public void setPatientTreatment(String patientTreatment) {
        this.patientTreatment = patientTreatment;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
