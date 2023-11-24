package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class StudentM implements StudentM_I {
	private static final int INITIAL_STUDENT_ID = 1001; // 起始学员编号
    private static int nextStudentId = INITIAL_STUDENT_ID;

    @Override
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== 添加学员信息 ==============");
        System.out.print("请输入学员姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入学员电话：");
        String phoneNumber = scanner.nextLine();
        System.out.print("请输入学员年级：");
        int grade = scanner.nextInt();

        Student student = new Student(nextStudentId++, name, phoneNumber, grade);
        // 将学员信息加入学员列表
        studentList.add(student);

        System.out.println("成功添加学员信息，学员编号为：" + student.getStudentId());
    }

    @Override
    public void viewStudentList() {
        System.out.println("============== 查看学员列表 ==============");
        if (studentList.isEmpty()) {
            System.out.println("暂无学员信息。");
        } else {
            for (Student student : studentList) {
                System.out.println("学员编号: " + student.getStudentId() +
                                   " | 姓名: " + student.getName() +
                                   " | 电话: " + student.getPhoneNumber() +
                                   " | 年级: " + student.getGrade());
            }
        }
    }

    @Override
    public void viewDetailedStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== 查看详细学员信息 ==============");
        System.out.print("请输入学员编号：");
        int studentId = scanner.nextInt();

        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("学员详细信息：");
            System.out.println("学员编号: " + student.getStudentId());
            System.out.println("姓名: " + student.getName());
            System.out.println("电话: " + student.getPhoneNumber());
            System.out.println("年级: " + student.getGrade());
        } else {
            System.out.println("未找到对应编号的学员信息。");
        }
    }

    @Override
    public void modifyStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== 修改学员信息 ==============");
        System.out.print("请输入学员编号：");
        int studentId = scanner.nextInt();

        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.print("请输入新的学员姓名（回车保持不变）：");
            scanner.nextLine(); // 消耗换行符
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                student.setName(newName);
            }

            System.out.print("请输入新的学员电话（回车保持不变）：");
            String newPhoneNumber = scanner.nextLine();
            if (!newPhoneNumber.isEmpty()) {
                student.setPhoneNumber(newPhoneNumber);
            }

            System.out.print("请输入新的学员年级（回车保持不变）：");
            String newGrades = scanner.nextLine();
            if (!newGrades.isEmpty()) {
	            try {
	            	int newGrade = Integer.parseInt(newGrades);
	            	student.setGrade(newGrade);
	            } catch (NumberFormatException e) {
	                System.out.println("字符串无法转换为整数：" + e.getMessage());
	            }
            }
            System.out.println("学员信息修改成功。");
        } else {
            System.out.println("未找到对应编号的学员信息。");
        }
    }

    @Override
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== 删除学员 ==============");
        System.out.print("请输入学员编号：");
        int studentId = scanner.nextInt();

        Student student = findStudentById(studentId);

        if (student != null) {
            studentList.remove(student);
            System.out.println("学员删除成功。");
        } else {
            System.out.println("未找到对应编号的学员信息。");
        }
    }

    // 学员列表
    private static ArrayList<Student> studentList = new ArrayList<>();

    // 根据学员编号查找学员
    public Student findStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
