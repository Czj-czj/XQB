package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
public class XQBM implements XQBM_I {
    private ArrayList<XQB> xqbList = new ArrayList<>();
    private int nextClassId = 1;

    @Override
    public void addInterestClass() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("============== 添加兴趣班信息 ==============");
        System.out.print("请输入兴趣班名称：");
        String className = scanner.nextLine();
        System.out.print("请输入授课时间：");
        String classTime = scanner.nextLine();
        System.out.print("请输入授课地点：");
        String classLocation = scanner.nextLine();
        System.out.print("请输入授课总次数：");
        int totalSessions = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        System.out.print("请输入授课教师：");
        String teacher = scanner.nextLine();
        System.out.print("请输入费用：");
        double fee = scanner.nextDouble();

        XQB xqb = new XQB(nextClassId++, className, classTime, classLocation, totalSessions, teacher, fee);
        xqbList.add(xqb);

        System.out.println("成功添加兴趣班信息，编号为：" + xqb.getClassId());
    }

    @Override
    public void viewInterestClassList() {
    	System.out.println("============== 查看兴趣班列表 ==============");
        if (xqbList.isEmpty()) {
            System.out.println("暂无兴趣班信息。");
        } else {
            for (XQB xqb : xqbList) {
                System.out.println("编号: " + xqb.getClassId() + " | 兴趣班名称: " + xqb.getClassName());
            }
        }
    }

    @Override
    public void viewDetailedInterestClass() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("============== 查看详细兴趣班信息 ==============");
        System.out.print("请输入兴趣班编号：");
        int classId = scanner.nextInt();

        XQB xqb = findInterestClassById(classId);

        if (xqb != null) {
            System.out.println("兴趣班详细信息：");
            System.out.println("编号: " + xqb.getClassId());
            System.out.println("兴趣班名称: " + xqb.getClassName());
            System.out.println("授课时间: " + xqb.getClassTime());
            System.out.println("授课地点: " + xqb.getClassLocation());
            System.out.println("授课总次数: " + xqb.getTotalSessions());
            System.out.println("授课教师: " + xqb.getTeacher());
            System.out.println("费用: " + xqb.getFee());
        } else {
            System.out.println("未找到对应编号的兴趣班信息。");
        }
    }

    @Override
    public void modifyInterestClass() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("============== 修改兴趣班信息 ==============");
        System.out.print("请输入兴趣班编号：");
        int classId = scanner.nextInt();

        XQB xqb = findInterestClassById(classId);

        if (xqb != null) {
            System.out.print("请输入新的兴趣班名称（回车保持不变）：");
            scanner.nextLine(); // 消耗换行符
            String newClassName = scanner.nextLine();
            if (!newClassName.isEmpty()) {
                xqb.setClassName(newClassName);
            }

            // TODO: 允许用户修改其他属性

            System.out.println("兴趣班信息修改成功。");
        } else {
            System.out.println("未找到对应编号的兴趣班信息。");
        }
    }

    @Override
    public void deleteInterestClass() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("============== 删除兴趣班 ==============");
        System.out.print("请输入兴趣班编号：");
        int classId = scanner.nextInt();

        XQB xqb = findInterestClassById(classId);

        if (xqb != null) {
            xqbList.remove(xqb);
            System.out.println("兴趣班删除成功。");
        } else {
            System.out.println("未找到对应编号的兴趣班信息。");
        }
    }
    
    @Override
    public XQB findInterestClassById(int classId) {
        for (XQB xqb : xqbList) {
            if (xqb.getClassId() == classId) {
                return xqb;
            }
        }
        return null;
    }
}
