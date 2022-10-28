public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       // System.out.print("Enter date of birth in YYYY-MM-DD format: ");
        Student student = new Student("Juana", "2000-02-26");
        //System.out.println(student.getAge());
        //System.out.println(student.getId());
        //System.out.println(student.getName());

        FullTimeTeacher teacher1 = new FullTimeTeacher("Juan", 15);
        System.out.println(teacher1.getName());
        System.out.println(teacher1.getSalary());
        System.out.println(teacher1.calculateSalary());
        System.out.println(teacher1.getExperienceYears());
        System.out.println(teacher1.BASESALARY);
        System.out.println(teacher1.calculateSalary());


    }
}