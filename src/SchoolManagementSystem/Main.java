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

            System.out.printf("entering score for student %d", i + 1);
            for (int j = 0; j < subject; j++) {
                System.out.printf("Enter score for SUBJECT :%d ", j + 1);
                studentGrade.addScore(i,j,userInput.nextInt());
            }
            System.out.println("Press 0 to end  or 1 to enter another score:");
            choice = userInput.nextInt();
            i++;

        }
        studentGrade.displayGrades();


//        do {
//            System.out.println("Enter score for SUBJECT 1: ");
//            studentGrade.setScores(userInput.nextInt());
//
//            System.out.println("Enter score for SUBJECT 2: ");
//            studentGrade.setScores(userInput.nextInt());
//
//            System.out.println("Enter score for SUBJECT 3: ");
//            studentGrade.setScores(userInput.nextInt());

//
//            System.out.println("Press 0 to end  or 1 to enter another score:");
//            choice = userInput.nextInt();
//        } while (choice == 1);




    }
}
