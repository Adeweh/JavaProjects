package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class School {
    private final List<Student> studentList = new ArrayList<>();
    int numOfSubjects;
    int numberOfStudents;

    public School(int students, int subjects) {
        numOfSubjects = subjects;
        numberOfStudents = students;
        for (int i = 0; i < students; i++) {
            Student student = new Student(subjects);
            studentList.add(student);
        }
    }

    public int getNumOfSubjects() {
        return numOfSubjects;
    }


    public Student getStudent(int studentNo) {
        return studentList.get(studentNo);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public int getPosition(int studentNo) {
        HashMap<Integer, Integer> scoreAndPos = new HashMap<>();
        List<Integer> studentTotals = new ArrayList<>(studentList.stream().map(Student::getTotal).toList());
        int index = 1;
        while (studentTotals.size() > 0) {
            int max = findMax(studentTotals);
            scoreAndPos.put(max, index);
            studentTotals.remove((Object) max);
            index++;
        }
        int total = studentList.get(studentNo).getTotal();

        return scoreAndPos.get(total);


    }

    public int findMax(List<Integer> integers) {
        IntStream stream = integers.stream().flatMapToInt(IntStream::of);
        OptionalInt obj = stream.max();
        if (obj.isPresent()) {
            return obj.getAsInt();
        }
        return -1;
    }

    int max;
    int min;

    int noOfPasses = 0;
    int noOfFails = 0;

    private ArrayList<Integer> getSubjectScores(int subNo) {
        ArrayList<Integer> scores = new ArrayList<>();
        for (Student student : studentList) {
            scores.add(student.getSubjects().get(subNo).getScore());
        }
        return scores;
    }

    public int getTotal(int subNo) {
        return getSubjectScores(subNo).stream().reduce(Integer::sum).get();
    }

    public int getHighestScoringStudent(int subjectNo) {
        ArrayList<Integer> scores = new ArrayList<>();
        for (Student student : studentList) {
            scores.add(student.getSubjects().get(subjectNo).getScore());
        }
        max = scores.get(0);
        for (int score: scores){
            if ( score >=max){
                max = score;
            }
        }

        for (int i = 0; i <= studentList.size(); i++) {
            Subject subject = studentList.get(i).getSubjects().get(subjectNo);

            if (max == subject.getScore()) {
                return i + 1;
            }
        }
        return -1;
    }


    public int getHighestScore() {

        return max;
    }


    public int getNoOfPasses(int sub) {
        return getSubjectScores(sub).stream().filter(score -> score >= 50).toList().size();

    }


    public int getNoOfFails(int sub) {
        return getSubjectScores(sub).stream().filter(score -> score < 50).toList().size();
    }


    public int getHardestSubject() {
        List<Subject> subjects = studentList.get(0).getSubjects();
        int max = 0;
        for (Subject subject : subjects) {
            if (subject.getScore() < max) {
                max = subject.getScore();
            }

        }
        for (Subject subject : subjects) {
            if (subject.getScore() == max) {
                return subjects.indexOf(subject);
            }
        }
        return -1;
    }

    public int getEasiestSubject() {
        List<Subject> subjects = studentList.get(0).getSubjects();
        int min = 101;

        for (Subject subject : subjects) {

            if (subject.getScore() > min) {
                min = subject.getScore();
            }
        }
        for (Subject subject : subjects) {
            if (subject.getScore() == min) {
                return subjects.indexOf(subject);
            }
        }
        return -1;
    }

    private int getHighest() {
        int highestScore = 0;
        for (Student student : studentList) {
            for (Subject subject : student.getSubjects()) {
                if (subject.getScore() > highestScore) {
                    highestScore = subject.getScore();
                }
            }
        }
        return highestScore;
    }

    public int getOverallHighestScore() {
        return getHighest();
    }

    public int getStudentWithOverallHighest() {
        int highestScore = getHighest();

        for (Student student : studentList) {
            for (Subject subject : student.getSubjects()) {
                if (subject.getScore() == highestScore) {
                    return studentList.indexOf(student);
                }
            }
        }
        return -1;
    }

    public int getSubWithOverallHighestScore() {
        int highestScore = getHighest();

        for (Student student : studentList) {
            for (Subject subject : student.getSubjects()) {
                if (subject.getScore() == highestScore) {
                    return student.getSubjects().indexOf(subject);
                }
            }
        }
        return -1;
    }



}
