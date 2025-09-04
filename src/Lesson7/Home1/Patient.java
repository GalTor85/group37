package Lesson7.Home1;

class Patient {
    private int treatmentPlan=0;
    private Doctor doctor = new Doctor(); //fix вызова метода без назначения врача

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
