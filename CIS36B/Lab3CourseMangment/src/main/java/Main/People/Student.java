package Main.People;

import Main.Course.Course;

import java.util.ArrayList;
import java.util.Arrays;

public class Student extends Person{

    private final int gpa;
    private final ArrayList<Course> courses;

    public Student(String name, int gpa, Course... courses) {
        super(name);

        this.gpa = gpa;
        this.courses = new ArrayList<>();

        if (courses.length > 0) {
            this.courses.addAll(Arrays.asList(courses));
        }
    }

    public void showRegistration(){
        System.out.println("courses taking");
        for (Course course: courses){
            System.out.println(course.toString());
        }
    }


}
