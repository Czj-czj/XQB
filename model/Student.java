package model;

public class Student {
    private int studentId;
    private String name;
    private String phoneNumber;
    private int grade;

    // 构造方法
    public Student(int studentId, String name, String phoneNumber, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
    }

    // Getter和Setter方法
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
