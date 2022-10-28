package org.globantUniversity.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachersList;
    private List<Student> studentsList;
    private List<Lesson> lessonsList;

public University(){
    this.teachersList = new ArrayList<>();
    this.studentsList = new ArrayList<>();
    this.lessonsList = new ArrayList<>();
}

    public List<Teacher> getTeachersList() {
        return this.teachersList;
    }

    public List<Student> getStudentsList() {
        return this.studentsList;
    }

    public List<Lesson> getLessonsList() {
        return this.lessonsList;
    }
    public void addTeacher(Teacher teacher) {
        this.teachersList.add(teacher);
    }
}
