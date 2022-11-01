package org.globantUniversity.persistence;

import org.globantUniversity.data.Student;
import org.globantUniversity.data.PartTimeTeacher;
import org.globantUniversity.data.FullTimeTeacher;
import org.globantUniversity.data.Subject;
import org.globantUniversity.data.University;
import org.globantUniversity.data.Teacher;

public class DataInitializer {
    public static University loadUniversity() {
        University university = new University();
        loadTeachersIntoUniversity(university);
        loadStudentsIntoUniversity(university);
        loadSubjectsIntoUniversity(university);
        return university;
    }

    private static void loadTeachersIntoUniversity(University university) {
        Teacher partTimeTeacher1 = new PartTimeTeacher("Juan Bedoya", (byte) 15);
        Teacher partTimeTeacher2 = new PartTimeTeacher("Ximena Montañez", (byte) 20);
        Teacher fullTimeTeacher1 = new FullTimeTeacher("Felipe Bravo", (byte) 4);
        Teacher fullTimeTeacher2 = new FullTimeTeacher("Sofia Rozo", (byte) 10);
        university.addTeacher(partTimeTeacher1);
        university.addTeacher(partTimeTeacher2);
        university.addTeacher(fullTimeTeacher1);
        university.addTeacher(fullTimeTeacher2);
    }

    private static void loadStudentsIntoUniversity(University university) {
        Student student1 = new Student("Laura Bernal", "13-12-1993");
        Student student2 = new Student("Luisa Burgos", "05-07-1993");
        Student student3 = new Student("Daniel Alzate", "06-06-1980");
        Student student4 = new Student("Daniel Pépez", "06-06-1980");
        Student student5 = new Student("Jaime Agudelo", "06-06-1980");
        Student student6 = new Student("María Serna", "06-06-1980");
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
        university.addStudent(student4);
        university.addStudent(student5);
        university.addStudent(student6);
    }

    private static void loadSubjectsIntoUniversity(University university) {
        Subject subject1 = new Subject("Drama", "A1");
        Subject subject2 = new Subject("Alien Psychology", "B2");
        Subject subject3 = new Subject("History of guaracha", "C3");
        Subject subject4 = new Subject("Home economics", "D4");

        university.addSubject(subject1);
        university.addSubject(subject2);
        university.addSubject(subject3);
        university.addSubject(subject4);

        university.addTeacherToSubject( university.getSubjectByIndex(0), university.getTeacherByIndex(0) );
        university.addTeacherToSubject( university.getSubjectByIndex(1), university.getTeacherByIndex(1) );
        university.addTeacherToSubject( university.getSubjectByIndex(2), university.getTeacherByIndex(2) );
        university.addTeacherToSubject( university.getSubjectByIndex(3), university.getTeacherByIndex(3) );

        university.addStudentToSubject( university.getSubjectByIndex(0), university.getStudentByIndex(0) );
        university.addStudentToSubject( university.getSubjectByIndex(0), university.getStudentByIndex(1) );
        university.addStudentToSubject( university.getSubjectByIndex(1), university.getStudentByIndex(2) );
        university.addStudentToSubject( university.getSubjectByIndex(1), university.getStudentByIndex(3) );
        university.addStudentToSubject( university.getSubjectByIndex(2), university.getStudentByIndex(4) );
        university.addStudentToSubject( university.getSubjectByIndex(2), university.getStudentByIndex(5) );
        university.addStudentToSubject( university.getSubjectByIndex(3), university.getStudentByIndex(4) );
        university.addStudentToSubject( university.getSubjectByIndex(3), university.getStudentByIndex(0) );

    }
}
