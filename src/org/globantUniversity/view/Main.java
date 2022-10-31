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
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\nWelcome to the X university");
            System.out.println("\nType 1 to see all the professors");
            System.out.println("Type 2 to see all courses taught");
            System.out.println("Type 3 to register a new student");
            System.out.println("Type 4 to create a new subject");
            System.out.println("Type 5 to see the subjects a student attends");
            System.out.println("Type 6 to exit");
            String option = scan.nextLine();
            scan = new Scanner(System.in);
            switch (option) {
                case "1":
                    printTeachersList(university);
                    break;
                case "2":
                    printSubjectsList(university);
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("Please type a valid option");
                    break;
            }
        } while (!exit);
    }

    public static void printTeachersList(University university) {
        if (university.getNumberOfTeachers() == 0) {
            System.out.println("there are no registered professors");
        } else {
            for (int i = 0; i < university.getNumberOfTeachers(); i++) {
                System.out.println(i + 1 + ". " + university.getTeacherInfoByIndex(i));
            }
        }
    }

    public static void printSubjectsList(University university) {
        if (university.getNumberOfSubjects() == 0) {
            System.out.println("There are no registered subjects");
        } else {
            boolean exit = false;
            do {
                System.out.println("\nType the number of the subject for more details:");
                for (int i = 0; i < university.getNumberOfSubjects(); i++) {
                    System.out.println(i + 1 + ". " + university.getSubjectNameByIndex(i));
                }
                System.out.println(university.getNumberOfSubjects() + 1 + ". Back to the menu");
                Scanner scan = new Scanner(System.in);
                int option = scan.nextInt();
                option = option - 1;
                if(option == university.getNumberOfSubjects()){
                    exit = true;
                } else {printSubjectDetails(option, university);}
            } while (!exit);
        }
    }

    public static void printSubjectDetails(int index, University university) {
        if (index < 0 || index >= university.getNumberOfSubjects()) {
            System.out.println("Please type a valid number");
        } else {
            System.out.println(university.getSubjectDetailsByIndex(index));
        }
    }

}
