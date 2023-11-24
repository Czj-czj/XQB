package model;

public class CourseSelection {
    private int studentId;
    private int classId;

    // 构造函数
    public CourseSelection(int studentId, int classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    // Getter 和 Setter 方法...
    public int getStudentId() {
    	return this.studentId;
    }
    public int getClassId() {
    	return this.classId;
    }
    // 重写 toString 方法，用于调试和输出信息
    @Override
    public String toString() {
        return "CourseSelection{" +
                "studentId=" + studentId +
                ", classId=" + classId +
                '}';
    }
}
