package Lesson8.Practic2;

abstract public class Employee {
    private String name;
    private String id;

    void displayInfo() {
      System.out.println("Name: " + name);
      System.out.println("ID: " + id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    abstract void calculateSalary();

}
