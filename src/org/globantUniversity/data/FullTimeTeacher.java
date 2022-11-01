package org.globantUniversity.data;

import org.globantUniversity.data.Teacher;

public class FullTimeTeacher extends Teacher {
    /**
     * Represents a professor that works full-time.
     */
    private byte experienceYears;

    public FullTimeTeacher(String name, byte experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
        this.salary = this.calculateSalary();
        TypeOfContract = "Full time";
    }

    public void setExperienceYears(byte experienceYears) {
        this.experienceYears = experienceYears;
    }

    public byte getExperienceYears() {
        return this.experienceYears;
    }


    /**
     * @return the salary of the professor based on years of experience.
     */
    @Override
    protected float calculateSalary() {
        return (float) (BASESALARY * 1.1 * this.experienceYears);
    }
}
