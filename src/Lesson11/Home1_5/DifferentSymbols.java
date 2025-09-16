package Lesson11.Home1_5;

public class DifferentSymbols {
    static void load(String... arraysString) {

        for (String s : arraysString) {
            String[] string;
            string = s.split("\\s+");
            for (String value : string) {
                char[] ch = value.toCharArray();
                boolean count = true;

                for (int i = 0; i < ch.length - 1; i++) {
                    for (int j = i + 1; j < ch.length; j++) {
                        if (ch[i] == ch[j]) {
                            count = false;
                            break;
                        }
                        if ((i + 1 == (ch.length - 1)) && count) {
                            System.out.println("Первое уникальное слово " + value);
                            return;
                        }
                    }


                }
            }
        }
    }
}


