package org.globantUniversity.data;
public abstract class Teacher {
    /**
     * Represents a professor in the university.
     */
    protected String name;
    protected float salary;

    protected String TypeOfContract;
    protected final float BASESALARY = 2000;

   protected Teacher(String name){
       this.name = name;

   }
    protected abstract float calculateSalary();

    public float getSalary() {
        return this.salary;
    }
    public String getName() {
        return this.name;
    }

    public String getTypeOfContract() {
        return TypeOfContract;
    }
}
