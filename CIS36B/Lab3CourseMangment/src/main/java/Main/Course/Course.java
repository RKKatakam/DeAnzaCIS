package Main.Course;

import Main.People.Professor;
import Main.People.Student;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Course {

    private String name;
    private String description;
    private final String id;

    private int creditHours;
    private int maxSize;

    private Professor professor;
    private ArrayList<Student> students;

    public Course(String name, String description, int creditHours, int maxSize, Professor professor) {
        this.name = name;
        this.description = description;

        this.creditHours = creditHours;
        this.maxSize = maxSize;

        this.professor = professor;
        this.students = new ArrayList<>();

        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getProfessorName() {
        return professor.getName();
    }

    public String getId() {
        return id;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creditHours=" + creditHours +
                ", maxSize=" + maxSize +
                ", professor=" + professor +
                '}';
    }

    public void dropStudent(Student student) {
        students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
