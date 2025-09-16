package Lesson9.Home1_Star;

abstract class Animal {
    private String name="";
    private int age=0;
    private Double weight=0d;
    abstract void eat(String food);
    abstract void voice();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
