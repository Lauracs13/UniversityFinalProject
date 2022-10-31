package org.globantUniversity.view;

import org.globantUniversity.data.Student;

import org.globantUniversity.data.Subject;
import org.globantUniversity.data.Teacher;
import org.globantUniversity.data.University;
import org.globantUniversity.persistence.DataInitializer;


import java.util.List;
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
                case "3":
                    registerNewStudent(university);
                    break;
                case "4":
                   createSubject(university);
                    break;
                case "5":
                    subjectsStudentAttends(university);
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease type a valid option");
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
                if (option == university.getNumberOfSubjects()) {
                    exit = true;
                } else {
                    printSubjectDetails(option, university);
                }
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

    public static void registerNewStudent(University university) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write the name of the student");
        String name = scan.nextLine();
        scan = new Scanner(System.in);
        System.out.println("Write the day of birth (dd)");
        int day = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println("Write the month of birth (mm)");
        int month = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println("Write the year of birth (yyyy)");
        int year = scan.nextInt();
        scan = new Scanner(System.in);
if (isDateValid(day, month, year)){
    String fullDate = day + "-" + month + "-" + year + "-";
    Student student = new Student(name, fullDate);
    System.out.println(university.addStudent(student));
    addStudentToSubject(student, university);
} else {
    System.out.println("Please write a valid date");
}

    }

    public static void addStudentToSubject(Student student, University university) {

        if (university.getNumberOfSubjects() == 0) {
            System.out.println("There are no registered subjects");
        } else {
            boolean exit = false;
            do {
                System.out.println("\nType the number of the subject to add the student:");
                for (int i = 0; i < university.getNumberOfSubjects(); i++) {
                    System.out.println(i + 1 + ". " + university.getSubjectNameByIndex(i));
                }
                System.out.println(university.getNumberOfSubjects() + 1 + ". Back to the previous menu");
                Scanner scan = new Scanner(System.in);
                int option = scan.nextInt();
                option = option - 1;
                if (option == university.getNumberOfSubjects()) {
                    exit = true;
                } else {
                    addStudentToSubjectByIndex(student, university, option);
                }
            } while (!exit);
        }
    }
        public static void addStudentToSubjectByIndex(Student student, University university, int option) {
            if (option < 0 || option >= university.getNumberOfSubjects()) {
                System.out.println("Please type a valid number");
            } else {
                Subject currentSubject = university.getSubjectByIndex(option);
                currentSubject.addStudent(student);
            }
        }



    public static void createSubject(University university) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write the name of the subject");
        String name = scan.nextLine();
        scan = new Scanner(System.in);
        System.out.println("Write the assigned classroom");
        String classroom = scan.nextLine();
        Subject subject = new Subject(name, classroom);
        university.addSubject(subject);

        scan = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\nType 1 to add or replace a professor to the subject");
            System.out.println("Type 2 to add a student to the subject");
            System.out.println("Type 3 to go back to the menu");
            int option = scan.nextInt();
            scan = new Scanner(System.in);
            switch (option) {
                case 1:
                    addTeacherToSubject(subject, university);
                    break;
                case 2:
                    addStudentToSubject(subject, university);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Please type a valid option");
                    break;
            }
        } while (!exit);
    }

    public static void addTeacherToSubject(Subject subject, University university) {
        if (university.getNumberOfTeachers() == 0) {
            System.out.println("There are no registered professors");
        } else {
            boolean exit = false;
            do {
                System.out.println("\nType the number of the professor for the subject:");
                for (int i = 0; i < university.getNumberOfTeachers(); i++) {
                    System.out.println(i + 1 + ". " + university.getTeacherNameByIndex(i));
                }
                System.out.println(university.getNumberOfTeachers() + 1 + ". Back to the previous menu");
                Scanner scan = new Scanner(System.in);
                int option = scan.nextInt();
                option = option - 1;
                if (option == university.getNumberOfTeachers()) {
                    exit = true;
                } else {
                    addTeacherToSubjectByIndex(subject, university, option);
                }
            } while (!exit);
        }
    }
    public static void addTeacherToSubjectByIndex(Subject subject, University university, int option) {
        if (option < 0 || option >= university.getNumberOfTeachers()) {
            System.out.println("Please type a valid number");
        } else {
            Teacher currentTeacher = university.getTeacherByIndex(option);
            System.out.println( subject.addTeacher(currentTeacher) );
        }
    }

    public static void addStudentToSubject(Subject subject, University university) {
        if (university.getNumberOfStudents() == 0) {
            System.out.println("There are no registered students");
        } else {
            boolean exit = false;
            do {
                System.out.println("\nType the number of the student to be added:");
                for (int i = 0; i < university.getNumberOfStudents(); i++) {
                    System.out.println(i + 1 + ". " + university.getStudentNameByIndex(i));
                }
                System.out.println(university.getNumberOfStudents() + 1 + ". Back to the previous menu");
                Scanner scan = new Scanner(System.in);
                int option = scan.nextInt();
                option = option - 1;
                if (option == university.getNumberOfStudents()) {
                    exit = true;
                } else {
                    addStudentToSubjectByIndex(subject, university, option);
                }
            } while (!exit);
        }
    }
    public static void addStudentToSubjectByIndex(Subject subject, University university, int option) {
        if (option < 0 || option >= university.getNumberOfStudents()) {
            System.out.println("Please type a valid number");
        } else {
            Student currentStudent = university.getStudentByIndex(option);
            System.out.println( subject.addStudent(currentStudent) );
        }
    }

    public static void subjectsStudentAttends(University university){
        boolean exit = false;
        do {
            System.out.println("\nType the number of the student to see the subjects he/she attends:");
            for (int i = 0; i < university.getNumberOfStudents(); i++) {
                System.out.println(i + 1 + ". " + university.getStudentNameByIndex(i));
            }
            System.out.println(university.getNumberOfStudents() + 1 + ". Back to the previous menu");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            option = option - 1;
            if (option == university.getNumberOfStudents()) {
                exit = true;
            } else {
                Student currentStudent = university.getStudentByIndex(option);
                searchSubjectsByStudent(currentStudent, university);
            }
        } while (!exit);
    }

    public static void searchSubjectsByStudent(Student student, University university){
        List<String> subjectsAttended = university.searchSubjectsByStudentId(student.getId());
            System.out.println("\nThe subjects attended by student " + student.getName() + " are:");
            for (int i = 0; i < subjectsAttended.size(); i++) {
                System.out.println("-> " + subjectsAttended.get(i));
            }
    }

    // the following method is taken from https://www.geeksforgeeks.org/program-check-date-valid-not/
    public static boolean isDateValid(int day, int month, int year) {
        int MAX_VALID_YR = 9999;
        int MIN_VALID_YR = 1800;
        if (year > MAX_VALID_YR || year < MIN_VALID_YR) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (isLeap(year)) {
                return (day <= 29);
            } else {
                return (day <= 28);
            }
        }
        if (month == 4 || month == 6 ||
                month == 9 || month == 11)
            return (day <= 30);

        return true;
    }

    static boolean isLeap(int year) {
        return (((year % 4 == 0) &&
                (year % 100 != 0)) ||
                (year % 400 == 0));
    }
}
