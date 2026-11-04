package Mastery1;

public class Faculty extends UEmployee {
    private String department;

    public Faculty(String name, double salary, String departmentName) {
        super(name, salary);
        department = departmentName;
    }

    public String getDepartment() {
        return department;
    }
}