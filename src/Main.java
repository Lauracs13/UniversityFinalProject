public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       // System.out.print("Enter date of birth in YYYY-MM-DD format: ");
        Student student = new Student("Juana", "2000-02-26");
        System.out.println(student.getAge());
        System.out.println(student.getId());
        System.out.println(student.getName());

    }
}