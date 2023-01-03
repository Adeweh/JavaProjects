package SchoolManagementSystem;

import java.util.HashMap;

public class Grade {
    private final School school;

    public Grade(int students, int subjects) {
        school = new School(students, subjects);
    }

    public void addScore(int studentNo, int subject, int score) {
        Student student = school.getStudent(studentNo);
        student.setScore(subject, score);
    }


    public void displayGrades() {
        System.out.println("no of students " + school.getNumberOfStudents());
        System.out.println("=".repeat(70));
        System.out.print("STUDENT      ");
        for (int sample = 0; sample < school.getNumOfSubjects(); sample++) {
            System.out.printf("SUB%2d   ", sample + 1);


        }
        System.out.print("    TOT   ");
        System.out.print("  AVE");
        System.out.println("        POS");
        System.out.println("=".repeat(70));
        int count = 0;
        for (Student student : school.getStudents()) {
            System.out.printf("Student %2d", count + 1);

            for (Subject subject : student.getSubjects()) {
                System.out.printf("%8d", subject.getScore());
            }

            System.out.printf("%9d %8.2f %8d  %n", student.getTotal(), student.getAverage(), school.getPosition(count));
            count++;
        }

        System.out.println("=".repeat(70));
        System.out.println("=".repeat(70));

    }


    public void subjectSummary() {
        HashMap<Integer, SubjectData> sunAndNoOfFails = new HashMap<>();
        System.out.println("SUBJECT SUMMARY");
        for (int i = 0; i < school.getNumOfSubjects(); i++) {
            System.out.printf("Subject %2d %n", i + 1);
            System.out.printf("Highest scoring student is Student %d Scoring %d %n", school.getHighestScoringStudent(i), school.getHighestScore());
//            System.out.printf("Lowest scoring student is %d Scoring %d %n: ", school.getLowestScoringStudent(i), school.getLowestScore());
            System.out.println("Total Score: " + school.getTotal(i));
            System.out.println("Average Score: " + school.getTotal(i) / school.getNumOfSubjects());
            int passes = school.getNoOfPasses(i);
            int fails = school.getNoOfFails(i);
            sunAndNoOfFails.put(i,new SubjectData(passes, fails) );
            System.out.println("Number of passes: " + passes);
            System.out.println("Number of fails: " + fails);


        }
        int highestFails = 0;
        int index = 0;
        for (int i = 0; i< sunAndNoOfFails.size(); i++){
            if(sunAndNoOfFails.get(i).getNoOFFails() > highestFails){
                highestFails = sunAndNoOfFails.get(i).getNoOFFails();
                index = i;
            }
        }

        int highestPasses = 0;
        int id2 = 0;
        for (int i = 0; i< sunAndNoOfFails.size(); i++){
            if(sunAndNoOfFails.get(i).getNoOFPasses() > highestPasses){
                highestPasses = sunAndNoOfFails.get(i).getNoOFPasses();
                id2 = i;
            }
        }

        System.out.printf("The hardest subject is: Subject %d with %d failures %n", index+1, sunAndNoOfFails.get(index).getNoOFFails());

        System.out.printf("The easiest subject is: Subject %d with %d passes %n", id2+1, sunAndNoOfFails.get(id2).getNoOFPasses());

        System.out.printf("The overall Highest score is scored by Student %d in subject %d scoring %d %n", school.getStudentWithOverallHighest(), school.getSubWithOverallHighestScore(), school.getOverallHighestScore());
//        System.out.printf("The overall Lowest score is scored by Student %d in subject %d scoring %d", );


    }

}

