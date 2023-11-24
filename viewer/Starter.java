package viewer;
import java.util.*;
import controller.*;
public class Starter
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        XQBM_I xqbm = new XQBM();
        StudentM_I studentManager = new StudentM();
        CourseSelectionManager_I courseSelectionManager = new CourseSelectionManager();
        while(true) {
            // 打印菜单
            System.out.println( "============== 兴趣班管理系统 ==============" );
            System.out.println( "功能选项：" );
            System.out.println( "X - 兴趣班信息管理" );
            System.out.println( "S - 学员信息管理" );
            System.out.println( "M - 学员报班管理" );
            System.out.println( "Q - 退出系统" );
            System.out.print( "请选择功能（输入对应字母）：" );

            // 获取用户输入
            String choice = scanner.next().toUpperCase();

            // 处理用户选择
            switch(choice) {
            case "X":
                System.out.println( "进入兴趣班信息管理功能" );
                // TODO: 调用兴趣班信息管理的相关方法
                manageInterestClasses( xqbm );
                break;
            case "S":
                System.out.println( "进入学员信息管理功能" );
                // TODO: 调用学员信息管理的相关方法
                manageStudentInformation( studentManager );
                break;
            case "M":
                System.out.println( "进入学员报班管理功能" );
                // TODO: 调用学员报班管理的相关方法
                manageCourseEnrollment( courseSelectionManager, xqbm, studentManager );
                break;
            case "Q":
                System.out.println( "退出系统，谢谢使用！" );
                System.exit( 0 );
            default:
                System.out.println( "无效的选项，请重新输入。" );
            }
        }
    }
    private static void manageInterestClasses( XQBM_I xqbm )
    {
        Scanner scanner = new Scanner( System.in );
        while(true) {
            // 兴趣班信息管理菜单...
            System.out.println( "============== 兴趣班信息管理 ==============" );
            System.out.println( "1 - 添加兴趣班信息" );
            System.out.println( "2 - 查看兴趣班列表" );
            System.out.println( "3 - 查看详细兴趣班信息" );
            System.out.println( "4 - 修改兴趣班信息" );
            System.out.println( "5 - 删除兴趣班" );
            System.out.println( "0 - 返回上级菜单" );
            System.out.print( "请选择操作（输入对应数字）：" );

            int operation = scanner.nextInt();

            switch(operation) {
            case 1:
                xqbm.addInterestClass();
                break;
            case 2:
                xqbm.viewInterestClassList();
                break;
            case 3:
                xqbm.viewDetailedInterestClass();
                break;
            case 4:
                xqbm.modifyInterestClass();
                break;
            case 5:
                xqbm.deleteInterestClass();
                break;
            case 0:
                return;
            default:
                System.out.println( "无效的选项，请重新输入。" );
            }
        }
    }
    private static void manageStudentInformation( StudentM_I studentManager )
    {
        Scanner scanner = new Scanner( System.in );

        while(true) {
            // 学员管理主菜单...
            System.out.println( "============== 学员信息管理系统 ==============" );
            System.out.println( "1 - 添加学员信息" );
            System.out.println( "2 - 查看学员列表" );
            System.out.println( "3 - 查看详细学员信息" );
            System.out.println( "4 - 修改学员信息" );
            System.out.println( "5 - 删除学员" );
            System.out.println( "0 - 返回上级" );
            System.out.print( "请选择操作（输入对应数字）：" );
            String choices = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt( choices );
            }
            catch(NumberFormatException e) {
                System.out.println( "输入有误，字符串无法转换为整数：" );
                choice = 6;
            }
            switch(choice) {
            case 1:
                studentManager.addStudent();
                break;
            case 2:
                studentManager.viewStudentList();
                break;
            case 3:
                studentManager.viewDetailedStudent();
                break;
            case 4:
                studentManager.modifyStudent();
                break;
            case 5:
                studentManager.deleteStudent();
                break;
            case 0:
                return;
            default:
                System.out.println( "无效的选项，请重新输入。" );
            }
        }
    }

    private static void manageCourseEnrollment( CourseSelectionManager_I courseSelectionManager, XQBM_I xqbm, StudentM_I studentManager )
    {
        Scanner scanner = new Scanner( System.in );

        while(true) {
            // 学员报班管理菜单...
            System.out.println( "============== 学员报班管理 ==============" );
            System.out.println( "1 - 学员报班" );
            System.out.println( "2 - 学员取消报班" );
            System.out.println( "3 - 查看学员报名的所有课程" );
            System.out.println( "4 - 查看课程的所有报名学员" );
            System.out.println( "0 - 返回上级菜单" );
            System.out.print( "请选择操作（输入对应数字）：" );

            int operation = scanner.nextInt();

            switch(operation) {
            case 1:
                System.out.print( "请输入学员ID：" );
                int studentId = scanner.nextInt();
                if(studentManager.findStudentById(studentId) == null) {
                	System.out.println("学员不存在，请检查你的学号输入是否有误！");
                	break;
                }
                System.out.print( "请输入课程ID：" );
                int classId = scanner.nextInt();
                if(xqbm.findInterestClassById(classId)==null) {
                	System.out.println("课程不存在，请检查你的课程ID输入是否有误！");
                	break;
                }
                courseSelectionManager.enrollStudentInClass( studentId, classId );
                System.out.println( "学员报班成功。" );
                break;
            case 2:
                System.out.print( "请输入学员ID：" );
                int studentIdToCancel = scanner.nextInt();
                if(studentManager.findStudentById(studentIdToCancel) == null) {
                	System.out.println("学员不存在，请检查你的学号输入是否有误！");
                	break;
                }
                System.out.print( "请输入课程ID：" );
                int classIdToCancel = scanner.nextInt();
                if(xqbm.findInterestClassById(classIdToCancel)==null) {
                	System.out.println("课程不存在，请检查你的课程ID输入是否有误！");
                	break;
                }
                courseSelectionManager.cancelEnrollment( studentIdToCancel, classIdToCancel );
                System.out.println( "学员取消报班成功。" );
                break;
            case 3:
                System.out.print( "请输入学员ID：" );
                int studentIdToQuery = scanner.nextInt();
                if(studentManager.findStudentById(studentIdToQuery) == null) {
                	System.out.println("学员不存在，请检查你的学号输入是否有误！");
                	break;
                }
                courseSelectionManager.viewStudentEnrolledClasses( studentIdToQuery );
                break;
            case 4:
                System.out.print( "请输入课程ID：" );
                int classIdToQuery = scanner.nextInt();
                if(xqbm.findInterestClassById(classIdToQuery)==null) {
                	System.out.println("课程不存在，请检查你的课程ID输入是否有误！");
                	break;
                }
                courseSelectionManager.viewClassEnrolledStudents( classIdToQuery );
                break;
            case 0:
                return;
            default:
                System.out.println( "无效的选项，请重新输入。" );
            }
        }
    }
}
