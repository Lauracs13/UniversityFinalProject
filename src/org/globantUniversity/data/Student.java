package org.globantUniversity.data;

import java.time.LocalDate;
import java.time.Period;
public class Student {
    private String name;
    private int id;
    private static int count = 10000;
    private String dateOfBirth;
    private int age;

    public Student (String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = ageCalculator(dateOfBirth);
        this.id = count;
        count++;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public int ageCalculator(String dateOfBirth) {
        LocalDate dob = LocalDate.parse(dateOfBirth);
        LocalDate curDate = LocalDate.now();
        this.age = Period.between(dob, curDate).getYears();
        return this.age;
    }
}
