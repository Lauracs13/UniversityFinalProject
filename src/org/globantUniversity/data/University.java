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

    public int getNumberOfTeachers() {
        return this.teachersList.size();
    }

    public Teacher getTeacherByIndex(int index) {
        return this.teachersList.get(index);
    }

    public List<Student> getStudentsList() {
        return this.studentsList;
    }

    public Student getStudentByIndex(int index) {
        return this.studentsList.get(index);
    }

    public int getNumberOfStudents() {
        return this.studentsList.size();
    }

    public String getStudentNameByIndex(int index) {
        return this.studentsList.get(index).getName();
    }

    public List<Subject> getSubjectsList() {
        return this.subjectsList;
    }

    public int getNumberOfSubjects() {
        return this.subjectsList.size();
    }

    public Subject getSubjectByIndex(int index) {
        return this.subjectsList.get(index);
    }

    public String getSubjectNameByIndex(int index) {
        return this.subjectsList.get(index).getName();
    }

    public String getSubjectDetailsByIndex(int index) {
        Subject currentSubject = this.subjectsList.get(index);
        return "Subject " + currentSubject.getName() + " is taught by the professor " +
                currentSubject.getTeachersName() + " and the students are:" + currentSubject.getStudentsInfo();
    }

    public String getTeacherNameByIndex(int index) {
        return this.teachersList.get(index).getName();
    }

    public String getTeacherInfoByIndex(int index) {
        Teacher currentTeacher = this.teachersList.get(index);
        return "Name: " + currentTeacher.getName() + ", Type of contract: "
                + currentTeacher.getTypeOfContract() + ", Salary: $" + currentTeacher.getSalary();
    }

    public void addTeacher(Teacher teacher) {
        this.teachersList.add(teacher);
    }

    public String addStudent(Student student) {
        this.studentsList.add(student);
        return student.getName() + " successfully added to the university";
    }

    public String addSubject(Subject subject) {
        this.subjectsList.add(subject);
        return subject.getName() + " successfully added to the university";
    }

    public void addTeacherToSubject(Subject subject, Teacher teacher) {
        subject.addTeacher(teacher);
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subject.addStudent(student);
    }

    public List<String> searchSubjectsByStudentId(int id) {
        List<String> subjectsAttended = new ArrayList<>();
        for (Subject subject : this.subjectsList) {
            for (Student student : subject.getStudentsList()) {
                if (student.getId() == id) {
                    subjectsAttended.add(subject.getName());
                }
            }
        }
        return subjectsAttended;
    }
}
