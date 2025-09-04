package Lesson7.Home1;

public class Dentist extends Doctor {
    private String treatmentMethod = "Дантист";

    @Override
    public String getTreatmentMethod() {
        return treatmentMethod;
    }

}
