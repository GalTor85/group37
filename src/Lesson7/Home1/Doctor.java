package Lesson7.Home1;

class Doctor {
 private String treatmentMethod;
 public String getTreatmentMethod() {
  return treatmentMethod;
 }
 //метод лечение
 void treat() {
  if (getTreatmentMethod()!=null)                                   //проверка назначения
  System.out.println(this.getTreatmentMethod()+" выполнил лечение.");
  else System.out.println("Квалифицированное лечение невозможно");
 }
}
