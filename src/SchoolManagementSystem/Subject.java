package SchoolManagementSystem;

public class Subject {
    private int score;

    private int totalStudentScores;

    public void setScore(int score) {
        this.score = score;
    }



    public void setTotal(int total) {
        totalStudentScores = total;
    }

    public int getTotal() {
        return totalStudentScores;
    }

    public int getScore() {
        return score;
    }


}
