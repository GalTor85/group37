package Lesson11.Home1_5;

class MaxMin {


    static void load(String stringOne, String stringTwo, String stringThree){
        String[] arraysString = {stringOne, stringTwo, stringThree};
        String maxOut="";
        String minOut="";

        for (int i = arraysString.length-1; i >= 0 ; i--) {
            if ((Math.max(Math.max(stringOne.length(), stringTwo.length()), stringThree.length())) ==
                    arraysString[i].length()) {
                maxOut ="Наибольшая строка :" + arraysString[i] + " ее длина " + arraysString[i].length();

            }  if (Math.min(Math.min(stringOne.length(), stringTwo.length()), stringThree.length()) ==
                    arraysString[i].length()) {
                minOut="Наименьшая строка :" + arraysString[i] + " ее длина " + arraysString[i].length();

            }


        }
        System.out.println(maxOut);
        System.out.println(minOut);
    }

}
