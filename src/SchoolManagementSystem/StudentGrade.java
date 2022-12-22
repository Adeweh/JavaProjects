package SchoolManagementSystem;

import java.util.Arrays;

public class StudentGrade {
    private  String[] students;
    private  String[] subjects;
    private int [][] scores;
    private int [] totalStudentScores;
    private int[] position;

    private  int total = 0;

    public StudentGrade(int numOfStudents, int numOfSubjects){
        students = new String[numOfStudents];
        subjects = new String[numOfSubjects];
        scores = new int[students.length][subjects.length];
        totalStudentScores = new int[numOfStudents];
        position = new int[numOfStudents];


    }
    public void setScores(int score){
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if(scores[i][j] == 0){
                    scores[i][j] = score;
                    return;
                }

            }

        }
    }
    public void displayGrades(){
        gradeTable();

    }
    public  void gradeTable(){
            System.out.println("=".repeat(60));
            System.out.print("STUDENT      ");
            for (int sample = 0; sample < scores[0].length ; sample++) {
                System.out.printf("SUB%2d ", sample + 1);


            }
                System.out.print("    TOT   ");
                System.out.print("AVE");
                System.out.println("        POS");
                System.out.println("=".repeat(60));
                for (int student = 0; student < scores.length; student++) {
                    System.out.printf("Student %2d", student + 1);

                    for(int test: scores[student]){
                        System.out.printf("%8d", test);
                    }

                    int total = totalScore();
                    double average = averageScore(scores[student]);
                    int position = subjectPosition(scores[student]);
                    System.out.printf("%9d %9.2f   %n", total, average);
                }
                System.out.println("=".repeat(60));
                System.out.println("=".repeat(60));

    }

    public int subjectPosition(int[] position) {
        totalScore();

        int[] sortedTotalScores = new int[totalStudentScores.length];

        System.arraycopy(totalStudentScores, 0, sortedTotalScores, 0, totalStudentScores.length);
        Arrays.sort(sortedTotalScores);

        for (int i = 0; i < sortedTotalScores.length; i++) {
            int scoreIndex = Arrays.binarySearch(sortedTotalScores, totalStudentScores[i]);
            position[i] = students.length - scoreIndex;

        }


        return 0;
    }

    public double averageScore(int[] avgScore) {
        int total = 0;

        for(int grade: avgScore){
            total += grade;
        }
        return (double) total / avgScore.length;
    }

    public int totalScore() {
        for (int student = 0; student < students.length; student++) {
            total = 0;
            for (int subject = 0; subject < subjects.length; subject++) {
                total += scores[student][subject];

            }
            totalStudentScores[student] = total;
        }

        return 0;
    }

}
