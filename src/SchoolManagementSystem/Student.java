package SchoolManagementSystem;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private final List<Subject> subjectList = new ArrayList<>();

    public Student(int subjects){
        for (int i=0; i < subjects; i++){
            Subject subject = new Subject();
            subjectList.add(subject);
        }

    }



    public void setScore(int subject, int score) {
        Subject subject1 = subjectList.get(subject);
        subject1.setScore(score);
    }


    public List<Subject> getSubjects() {
        return subjectList;
    }

    public int getTotal() {
       return subjectList.stream().mapToInt(Subject::getScore).sum();
    }

    public double getAverage() {
        return subjectList.stream().mapToInt(Subject::getScore).average().getAsDouble();
    }


}
