public class Student {
    private String name;
    private int id;
    private int[] score;

    Student() {
        name = "default";
        id = 0;
        score = new int[6];
    }

//    Setters
    void setName(String n) {
        name =  n;
    }
    void setId(int i) {
        id = i;
    }
    void setScore(int[] s) {
        score = s;
    }

//    Getters
    String getName() {
        return name;
    }
    int getId() {
        return id;
    }
    int[] getScore() {
        return score;
    }

//    Calculate grade
    char gradeCal() {
        int sum=0;
        for (int i=0; i < score.length; i++) {
            sum += score[i];
        }

        int average = sum / score.length;
        char grade = '0';

        if (average >= 90 && average <= 100) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average < 60) {
            grade = 'F';
        } else {
            System.out.println("Invalid Scores ...");
        }
        System.out.println("Your Average Score: " + average);
        return grade;
    }

//    String Manipulation
    String strManipulation() {
        String[] list = name.split(" ");
        name = "";

        for (int i=0; i < list.length; i++) {
            char tempChar = list[i].charAt(0);
            String tempStr = Character.toString(tempChar);
            tempStr = tempStr.toUpperCase();
            tempStr = tempStr + list[i].substring(1);
            name += tempStr + " ";
        }
        return name;
    }
}
