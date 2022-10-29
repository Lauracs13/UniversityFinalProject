package org.globantUniversity.data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private String assignedClassroom;
    private List<Student> studentsList;
    private List<Teacher> teachersList;

    public Subject(String name, String assignedClassroom) {
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.studentsList = new ArrayList<>();
        this.teachersList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getAssignedClassroom() {
        return this.assignedClassroom;
    }

    public List<Student> getStudentsList() {
        return this.studentsList;
    }

    public List<Teacher> getTeachersList() {
        return this.teachersList;
    }

    public void setAssignedClassroom(String assignedClassroom) {
        this.assignedClassroom = assignedClassroom;
    }
    public void addTeacher(Teacher teacher) {
        this.teachersList.add(teacher);
    }
    public void addStudent(Student student) {
        this.studentsList.add(student);
    }

}
