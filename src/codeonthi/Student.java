
package codeonthi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    private String id;
    private String name;
    private Date dateOfBirth;
    private float gpa;
    private String major;
    private final float TUITION_FEE = 10000000; 

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float calculateTuitionFee() {
        if (gpa >= 9) {
            return TUITION_FEE * 0.5f; 
        }
        return TUITION_FEE; 
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    String formattedDate;
    if (getDateOfBirth() != null) {
        formattedDate = dateFormat.format(getDateOfBirth());
    } else {
        formattedDate = "N/A";  // Default value if dateOfBirth is null
    }
    
    System.out.println("ID: " + getId());
    System.out.println("Full Name: " + getFullName());
    System.out.println("Date of Birth: " + formattedDate);
    System.out.println("GPA: " + gpa);
    System.out.println("Major: " + major);

    if (gpa >= 9) {
        System.out.println("Scholarship: Yes (50%)");
    } else {
        System.out.println("Scholarship: No");
    }
    System.out.println("Tuition Fee: " + calculateTuitionFee() + " VND");
    System.out.println("----------------------------------");
    }

    public void addStudent(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }

    void setName(String newFullName) {
        this.name=name;
    }
    
}
