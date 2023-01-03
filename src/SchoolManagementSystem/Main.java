package SchoolManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner userInput = new Scanner(System.in);

        System.out.println("How many students do you have? ");
        int student = userInput.nextInt();


        System.out.println("How many subjects do they offer? ");
        int subject = userInput.nextInt();

        System.out.println("Saving>>>>>>>>>>>>");
        System.out.println("Saved Successfully");

        Grade studentGrade = new Grade(student, subject);


        int choice = 1;
        int i = 0;
        while (i < student && choice != 0) {

            System.out.printf("Entering score for STUDENT %2d", i + 1);
            System.out.println();
            for (int j = 0; j < subject; j++) {
                System.out.printf("Enter score for SUBJECT %2d: ", j + 1);
                int score = userInput.nextInt();
                while (score > 100 || score < 0) {
                    System.out.println("Invalid score:  please enter score between 0 and 100");
                    System.out.printf("Enter score for SUBJECT %2d: ", j + 1);
                    score = userInput.nextInt();
                }
                studentGrade.addScore(i, j, score);
            }
            System.out.println("Press 0 to end  or 1 to Enter for next Student:");
            choice = userInput.nextInt();
            while (choice > 1 || choice < 0) {
                System.out.println("invalid input ");
                System.out.println("Press 0 to end  or 1 to Enter for next Student:");
                choice = userInput.nextInt();
            }
            i++;

        }
        studentGrade.displayGrades();
        studentGrade.subjectSummary();
    }

}
