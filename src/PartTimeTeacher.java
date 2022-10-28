public class PartTimeTeacher extends Teacher {
    private float workWeekHours;


    public PartTimeTeacher(String name, float workWeekHours) {
        super(name);
        this.workWeekHours = workWeekHours;
        this.salary = calculateSalary();

    }

    public void setWorkWeekHours(float workWeekHours) {
        this.workWeekHours = workWeekHours;
    }

    public float getWorkWeekHours() {
        return workWeekHours;
    }

    @Override
    protected float calculateSalary() {
        return BASESALARY * (this.workWeekHours / 40);

    }
}
