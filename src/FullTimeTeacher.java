public class FullTimeTeacher extends Teacher {
    private float experienceYears;


    public FullTimeTeacher(String name, float experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
        this.salary = calculateSalary();

    }

    public void setExperienceYears(float experienceYears) {
        this.experienceYears = experienceYears;
    }

    public float getExperienceYears() {
        return this.experienceYears;
    }

    @Override
    protected float calculateSalary() {
        return (float) (BASESALARY * 1.1 * this.experienceYears);
    }
}
