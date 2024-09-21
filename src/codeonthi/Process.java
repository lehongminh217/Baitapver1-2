
package codeonthi;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Process {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by id");
            System.out.println("3. Delete a student by id");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Display students with scholarship");
            System.out.println("7. Display total tuition fees of all students");
            System.out.println("8. Exit");
            System.out.println("-----------------------------");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String dob = scanner.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateOfBirth = formatter.parse(dob);
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    studentList.addStudent(new Student(id, fullName, dateOfBirth, gpa, major));
                    System.out.println("-----------------------------");
                    break;

                case 2:
                   System.out.print("Enter ID of the student to update: ");
                    String updateId = scanner.nextLine();

                    Student studentToUpdate = studentList.findStudentById(updateId);
                    if (studentToUpdate != null) {
                        System.out.print("Enter new Full Name: ");
                        String newFullName = scanner.nextLine();
                        System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
                        String newDob = scanner.nextLine();
                        SimpleDateFormat newFormatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date newDateOfBirth = newFormatter.parse(newDob);
                        System.out.print("Enter new GPA: ");
                        float newGpa = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter new Major: ");
                        String newMajor = scanner.nextLine();

                        studentToUpdate.setName(newFullName);
                        studentToUpdate.setDateOfBirth(newDateOfBirth);
                        studentToUpdate.setGpa(newGpa);
                        studentToUpdate.setMajor(newMajor);

                        System.out.println("Student updated successfully.");
                        System.out.println("-----------------------------");
                    } else {
                        System.out.println("Student with ID " + updateId + " not found.");
                        System.out.println("-----------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of the student to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    System.out.println("Student deleted successfully.");
                    System.out.println("-----------------------------");
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students in the list.");
                        System.out.println("-----------------------------");
                    }
                    break;

                case 6:
                    studentList.displayStudentsWithScholarship();
                    break;

                case 7:
                    float totalTuitionFee = studentList.calculateTotalTuitionFee();
                    System.out.println("Total tuition fees of all students: " + totalTuitionFee + " VND");
                    System.out.println("-----------------------------");
                    break;

                case 8:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
                    System.out.println("-----------------------------");
                    break;
            }
        }

        scanner.close();
    }
}
