package Lesson7.Home1;

public class Surgeon extends Doctor {
    private String treatmentMethod = "Хирург";

    @Override
    public String getTreatmentMethod() {
        return treatmentMethod;
    }

}
