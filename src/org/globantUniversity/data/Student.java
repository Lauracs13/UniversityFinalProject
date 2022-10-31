package org.globantUniversity.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

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
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = formatter.parse(dateOfBirth);
            Instant instant = dob.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate dobFormatted = zone.toLocalDate();
            LocalDate curDate = LocalDate.now();
            this.age = Period.between(dobFormatted, curDate).getYears();
            return this.age;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

}
