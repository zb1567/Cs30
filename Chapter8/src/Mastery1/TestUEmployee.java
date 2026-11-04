package Mastery1;

public class TestUEmployee {
    public static void main(String[] args) {
        Faculty teacher = new Faculty(
            "Alex Smith", 85000.0, "Computer Science"
        );

        Staff worker = new Staff(
            "Sam Jones", 50000.0, "Office Assistant"
        );

        System.out.println("FACULTY");
        System.out.println("Name: " + teacher.getName());
        System.out.println("Salary: $" + teacher.getSalary());
        System.out.println("Department: " + teacher.getDepartment());

        System.out.println();

        System.out.println("STAFF");
        System.out.println("Name: " + worker.getName());
        System.out.println("Salary: $" + worker.getSalary());
        System.out.println("Job title: " + worker.getJobTitle());
    }
}