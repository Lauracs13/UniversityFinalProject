package org.globantUniversity.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachersList;
    private List<Student> studentsList;
    private List<Subject> subjectsList;

    public University() {
        this.teachersList = new ArrayList<>();
        this.studentsList = new ArrayList<>();
        this.subjectsList = new ArrayList<>();
    }

    public List<Teacher> getTeachersList() {
        return this.teachersList;
    }
    public Teacher getTeacherByIndex(int index){ return this.teachersList.get(index); }
    public List<Student> getStudentsList() {
        return this.studentsList;
    }
    public Student getStudentByIndex(int index){ return this.studentsList.get(index); }

    public List<Subject> getSubjectsList() {
        return this.subjectsList;
    }
    public Subject getSubjectByIndex(int index){ return this.subjectsList.get(index); }

    public void addTeacher(Teacher teacher) {
        this.teachersList.add(teacher);
    }

    public void addStudent(Student student) {
        this.studentsList.add(student);
    }

    public void addSubject(Subject subject) {
        this.subjectsList.add(subject);
    }

    public void addTeacherToSubject(Subject subject, Teacher teacher) {subject.addTeacher(teacher); }
    public void addStudentToSubject(Subject subject, Student student) {subject.addStudent(student); }
}
