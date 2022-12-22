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
        IntStream stream =
                integers.stream().flatMapToInt(IntStream::of);
        OptionalInt obj = stream.max();
        if (obj.isPresent()) {
            return obj.getAsInt();
        }
        return -1;

    }
}
