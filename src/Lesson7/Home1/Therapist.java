package Lesson7.Home1;


public class Therapist extends Doctor {
    private String treatmentMethod = "Терапевт";   //метод лечения

    @Override
    public String getTreatmentMethod() {
        return treatmentMethod;
    }

    //метод назначения доктора
    String firstAppeal(Patient patient, Doctor... doctors) {
        for (Doctor doctor : doctors) {                                      //перебор входных переменных (массив)
            if (doctor instanceof Surgeon && patient.getTreatmentPlan() == 1) {
                patient.setDoctor(doctor);
                break;
            } else if (doctor instanceof Dentist && patient.getTreatmentPlan() == 2) {
                patient.setDoctor(doctor);
                break;
            } else if ((patient.getTreatmentPlan() != 1) && (patient.getTreatmentPlan() != 2))
                patient.setDoctor(this);
        }
        if (patient.getDoctor().getTreatmentMethod() == null) {
            return "Назначение невозможно нет врача";
        } else {
            return (this.getTreatmentMethod() + " назначил лечение у "
                    + patient.getDoctor().getTreatmentMethod().toLowerCase() + "а.");
        }
    }
}



