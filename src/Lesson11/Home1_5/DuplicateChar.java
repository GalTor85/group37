package Lesson11.Home1_5;

public class DuplicateChar {
    static void load(String... arraysString) {
        String newString="";
        for (String s : arraysString) {
            char[] ch = s.toCharArray();
            for (char c : ch) {
                newString = newString + c + c;
            }
    }
        System.out.println(newString);
    }
}

