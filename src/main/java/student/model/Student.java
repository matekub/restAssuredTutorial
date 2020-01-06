package student.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    public static Student create() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("java");
        courses.add("c++");
        Student student = new Student();
        student.setFirstName("Mateusz");
        student.setLastName("Kowalski");
        student.setEmail("Mateusz@Kowalski.com");
        student.setProgramme("IT");
        student.setCourses(courses);
        return student;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
