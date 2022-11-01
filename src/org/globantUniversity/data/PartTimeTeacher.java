package org.globantUniversity.data;

public class PartTimeTeacher extends Teacher {
    /**
     * Represents a professor that works part-time.
     */
    private byte workWeekHours;

    public PartTimeTeacher(String name, byte workWeekHours) {
        super(name);
        this.workWeekHours = workWeekHours;
        this.salary = calculateSalary();
        TypeOfContract = "Part time";

    }

    public void setWorkWeekHours(byte workWeekHours) {
        this.workWeekHours = workWeekHours;
    }

    public byte getWorkWeekHours() {
        return workWeekHours;
    }

    /**
     * @return the salary of a professor based on weekly working hours.
     */
    @Override
    protected float calculateSalary() {
        return BASESALARY * ((float) this.workWeekHours / 40);

    }
}
