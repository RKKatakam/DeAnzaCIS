package Main.People;

import Main.Course.Course;
import Main.Course.CourseLibrary;

import java.util.ArrayList;

public class Professor extends Person {

    private ArrayList<Course> courses;

    public Professor(String name) {
        super(name);

        this.courses = new ArrayList<>();
    }

    public void addClass(String name, String description, int creditHours, int maxSize){
        CourseLibrary.getCourseLibrary().addClass(new Course(name, description, creditHours, maxSize, this));
        this.courses.add(new Course(name, description, creditHours, maxSize, this));
    }

    public void showClasses(){
        for (Course course : courses){
            System.out.println(course.toString());
        }
    }


}
