package controller;

public interface CourseSelectionManager_I {
    // 学生报名兴趣班
    void enrollStudentInClass(int studentId, int classId);

    // 学生取消报名兴趣班
    void cancelEnrollment(int studentId, int classId);

    // 查看学生报名的所有兴趣班
    void viewStudentEnrolledClasses(int studentId);

    // 查看兴趣班的所有报名学生
    void viewClassEnrolledStudents(int classId);
}
