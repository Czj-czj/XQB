package model;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private int studentId;
    private int classId;

    public Enrollment(int studentId, int classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getClassId() {
        return classId;
    }
}

