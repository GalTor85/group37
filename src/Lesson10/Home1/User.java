package Lesson10.Home1;

public class User {
    private String name;
    private int age;
    private String gender;
    private int id;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return " Пользователь " + name + ", возраст: " + age + ", пол: " + gender + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (toString().equals(obj.toString())) {
            return true;
        } else {
            return false;
        }
    }

   @Override
    public int hashCode() {
       int hash;
        hash = name.length()*31;
        hash = hash + age * 21;
        hash = hash + gender.length() * 31;
       return hash;
    }


}
