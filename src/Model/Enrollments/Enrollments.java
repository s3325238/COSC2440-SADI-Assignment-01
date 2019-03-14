package Model.Enrollments;

import java.util.*;

public class Enrollments {

    private int studentIndex;
    private ArrayList courseIndex;
    private int semesterIndex;

    public Enrollments(int studentIndex, ArrayList courseIndex, int semesterIndex) {
        this.studentIndex = studentIndex;
        this.courseIndex = courseIndex;
        this.semesterIndex = semesterIndex;
    }

    public int getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(int studentIndex) {
        this.studentIndex = studentIndex;
    }

    public List getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(ArrayList courseIndex) {
        this.courseIndex = courseIndex;
    }

    public int getSemesterIndex() {
        return semesterIndex;
    }

    public void setSemesterIndex(int semesterIndex) {
        this.semesterIndex = semesterIndex;
    }
}
