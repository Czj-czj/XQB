package controller;

import model.Student;

public interface StudentM_I {
    void addStudent();
    void viewStudentList();
    void viewDetailedStudent();
    void modifyStudent();
    void deleteStudent();
    Student findStudentById(int studengId);
}
