package SchoolManagementSystem;

public class Grade {
    private final School school;
    public Grade(int students, int subjects){
         school = new School(students, subjects);
    }

    public void addScore(int studentNo, int subject, int score){
        Student student = school.getStudent(studentNo);
        student.setScore(subject, score);
    }


    public void displayGrades() {
        System.out.println("no of students " +school.getNumberOfStudents());
        System.out.println("=".repeat(60));
        System.out.print("STUDENT      ");
        for (int sample = 0; sample < school.getNumOfSubjects() ; sample++) {
            System.out.printf("SUB%2d ", sample + 1);


        }
        System.out.print("    TOT   ");
        System.out.print("AVE");
        System.out.println("        POS");
        System.out.println("=".repeat(60));
        int count = 0;
        for (Student student: school.getStudents()){
            System.out.printf("Student %2d", count +1);

            for (Subject subject: student.getSubjects()){
                System.out.printf("%8d", subject.getScore());
            }

            System.out.printf("%9d %9.2f %9d   %n", student.getTotal(),student.getAverage(), school.getPosition(count));
            count++;
        }

        System.out.println("=".repeat(60));
        System.out.println("=".repeat(60));

    }
}

