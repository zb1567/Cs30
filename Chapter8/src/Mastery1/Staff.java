package Mastery1;

public class Staff extends UEmployee {
    private String jobTitle;

    public Staff(String name, double salary, String title) {
        super(name, salary);
        jobTitle = title;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}