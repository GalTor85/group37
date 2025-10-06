package Lesson15.Home3;

import java.util.Arrays;
public class Student {
    private String name;
    private String group;
    private int course;
    private int[] ball;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int[] getBall() {
        return ball;
    }

    public void setBall(int[] ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return name + ", " + group + ", " + course + ", " + Arrays.toString(ball)+"\n";
    }

    public Student(String name, String group, int course, int[] ball) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.ball = ball;
    }
}
