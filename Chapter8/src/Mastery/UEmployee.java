package Mastery;

public class UEmployee {
    private String name;
    private double salary;

    public UEmployee(String employeeName, double employeeSalary) {
        name = employeeName;
        salary = employeeSalary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}