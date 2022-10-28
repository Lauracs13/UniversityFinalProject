package org.globantUniversity.data;
import org.globantUniversity.data.Teacher;
public class FullTimeTeacher extends Teacher {
    private byte experienceYears;


    public FullTimeTeacher(String name, byte experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
        this.salary = this.calculateSalary();

    }

    public void setExperienceYears(byte experienceYears) {
        this.experienceYears = experienceYears;
    }

    public byte getExperienceYears() {
        return this.experienceYears;
    }

    @Override
    protected float calculateSalary() {
        return (float) (BASESALARY * 1.1 * this.experienceYears);
    }
}
