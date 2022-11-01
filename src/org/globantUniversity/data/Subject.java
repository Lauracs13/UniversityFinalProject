package org.globantUniversity.data;

import java.util.ArrayList;
import java.util.List;


public class Subject {
    /**
     * Represents a subject taught at the university.
     */
    private String name;
    private String assignedClassroom;
    private List<Student> studentsList;
    private Teacher teacher;

    public Subject(String name, String assignedClassroom) {
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.studentsList = new ArrayList<>();

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

    public void setAssignedClassroom(String assignedClassroom) {
        this.assignedClassroom = assignedClassroom;
    }

    public String getTeachersName() {
        return this.teacher.getName();
    }


    public Student getStudentByIndex(int index) {
        return this.studentsList.get(index);
    }

    public int getNumberOfStudents() {
        return this.studentsList.size();
    }

    /**
     * @return a String with info about the names, ages, and ids of the students.
     */
    public String getStudentsInfo() {
        String studentsInfo = "";
        for (int i = 0; i < getNumberOfStudents(); i++) {
            Student currentStudent = this.getStudentByIndex(i);
            studentsInfo += "\n" + currentStudent.getName() + " , " + currentStudent.getAge()
                    + " years old, Id: " + currentStudent.getId();
        }
        return studentsInfo;
    }

    public String addStudent(Student student) {
        this.studentsList.add(student);
        return student.getName() + " with Id: " + student.getId() + " successfully added to the subject " + this.name;
    }

    public String addTeacher(Teacher teacher) {
        this.teacher = teacher;
        return teacher.getName() + " successfully added to the subject " + this.name;
    }
}
