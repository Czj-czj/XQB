package model;

public class XQB {
    // 编号
    private int classId;

    // 兴趣班名称
    private String className;

    // 授课时间
    private String classTime;

    // 授课地点
    private String classLocation;

    // 授课总次数
    private int totalSessions;

    // 授课教师
    private String teacher;

    // 费用
    private double fee;

    // 构造方法
    public XQB(int classId, String className, String classTime, String classLocation, int totalSessions, String teacher, double fee) {
        this.classId = classId;
        this.className = className;
        this.classTime = classTime;
        this.classLocation = classLocation;
        this.totalSessions = totalSessions;
        this.teacher = teacher;
        this.fee = fee;
    }

    // Getter 和 Setter 方法

    // 获取编号
    public int getClassId() {
        return classId;
    }

    // 设置编号
    public void setClassId(int classId) {
        this.classId = classId;
    }

    // 获取兴趣班名称
    public String getClassName() {
        return className;
    }

    // 设置兴趣班名称
    public void setClassName(String className) {
        this.className = className;
    }

    // 获取授课时间
    public String getClassTime() {
        return classTime;
    }

    // 设置授课时间
    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    // 获取授课地点
    public String getClassLocation() {
        return classLocation;
    }

    // 设置授课地点
    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    // 获取授课总次数
    public int getTotalSessions() {
        return totalSessions;
    }

    // 设置授课总次数
    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }

    // 获取授课教师
    public String getTeacher() {
        return teacher;
    }

    // 设置授课教师
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // 获取费用
    public double getFee() {
        return fee;
    }

    // 设置费用
    public void setFee(double fee) {
        this.fee = fee;
    }
}
