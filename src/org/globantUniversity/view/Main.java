package org.globantUniversity.view;
import org.globantUniversity.data.Student;
import org.globantUniversity.data.PartTimeTeacher;
import org.globantUniversity.data.FullTimeTeacher;
import org.globantUniversity.data.University;
import org.globantUniversity.persistence.DataInitializer;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    University university = DataInitializer.loadUniversity();

        System.out.println(university.getStudentByIndex(0).getAge());





    }
}