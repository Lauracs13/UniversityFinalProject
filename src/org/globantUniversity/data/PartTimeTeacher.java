package org.globantUniversity.data;

public class PartTimeTeacher extends Teacher {
    private byte workWeekHours;


    public PartTimeTeacher(String name, byte workWeekHours) {
        super(name);
        this.workWeekHours = workWeekHours;
        this.salary = calculateSalary();

    }

    public void setWorkWeekHours(byte workWeekHours) {
        this.workWeekHours = workWeekHours;
    }

    public byte getWorkWeekHours() {
        return workWeekHours;
    }

    @Override
    protected float calculateSalary() {
        return BASESALARY *  ((float) this.workWeekHours / 40);

    }
}
