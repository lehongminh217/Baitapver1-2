
package codeonthi;

import java.util.ArrayList;
import java.util.Date;

public class StudentList {

    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("-----------------------------");
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }

        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public void displayStudentsWithScholarship() {
        System.out.println("Students with Scholarship:");
        for (Student student : studentList) {
            if (student.getGpa() >= 9) {
                student.displayInfo();
            }
        }
        System.out.println("-----------------------------");
    }

    public float calculateTotalTuitionFee() {
        float totalTuitionFee = 0;
        for (Student student : studentList) {
            totalTuitionFee += student.calculateTuitionFee();
        }
        return totalTuitionFee;
    }

    void updateStudentById(String updateId, String newId, String newFullName, String format, float newGpa, String newMajor) {
        String id = null;
         Student student = findStudentById(id);
    if (student != null) {
        student.setId(newId);
             Date dateOfBirth = null;
        student.setDateOfBirth(dateOfBirth);
             float gpa = 0;
        student.setGpa(gpa);
             String major = null;
        student.setMajor(major);
        System.out.println("Student updated successfully.");
    } else {
        System.out.println("Student with ID " + id + " not found.");
    }
    }
}
