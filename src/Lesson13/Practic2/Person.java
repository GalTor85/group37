package Lesson13.Practic2;

public class Person {
    private String name;
    private int age;

    public int getAge() {

        return age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    public void setAge(int age) {
        try {
            if (age < 18) {
                throw new MyException(age, " < 18");
            }
            this.age = age;
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

