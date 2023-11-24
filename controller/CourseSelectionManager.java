package controller;

import model.CourseSelection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSelectionManager implements CourseSelectionManager_I {
    private List<CourseSelection> courseSelections;
    private Map<Integer, List<Integer>> studentEnrollments;
    private Map<Integer, List<Integer>> classEnrollments;

    // 构造函数
    public CourseSelectionManager() {
        this.courseSelections = new ArrayList<>();
        this.studentEnrollments = new HashMap<>();
        this.classEnrollments = new HashMap<>();
    }

    // 学生报名兴趣班
    @Override
    public void enrollStudentInClass(int studentId, int classId) {
        CourseSelection courseSelection = new CourseSelection(studentId, classId);
        courseSelections.add(courseSelection);

        // 维护学生报班信息
        studentEnrollments.computeIfAbsent(studentId, k -> new ArrayList<>()).add(classId);

        // 维护兴趣班报名学生信息
        classEnrollments.computeIfAbsent(classId, k -> new ArrayList<>()).add(studentId);
    }

    // 学生取消报名兴趣班
    @Override
    public void cancelEnrollment(int studentId, int classId) {
        courseSelections.removeIf(cs -> cs.getStudentId() == studentId && cs.getClassId() == classId);

        // 维护学生报班信息
        List<Integer> studentEnrollmentsList = studentEnrollments.get(studentId);
        if (studentEnrollmentsList != null) {
            studentEnrollmentsList.remove(Integer.valueOf(classId));
        }

        // 维护兴趣班报名学生信息
        List<Integer> classEnrollmentsList = classEnrollments.get(classId);
        if (classEnrollmentsList != null) {
            classEnrollmentsList.remove(Integer.valueOf(studentId));
        }
    }

    // 查看学生报名的所有兴趣班
    @Override
    public void viewStudentEnrolledClasses(int studentId) {
        List<Integer> enrolledClasses = studentEnrollments.getOrDefault(studentId, new ArrayList<>());
        System.out.println("学生ID为 " + studentId + " 所选的所有课程：" + enrolledClasses);
    }

    // 查看兴趣班的所有报名学生
    @Override
    public void viewClassEnrolledStudents(int classId) {
        List<Integer> enrolledStudents = classEnrollments.getOrDefault(classId, new ArrayList<>());
        System.out.println("选了课程ID为 " + classId + " 的所有学生：" + enrolledStudents);
    }
}
