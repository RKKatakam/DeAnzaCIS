package Main.People;

import Main.Course.Course;
import Main.Course.CourseLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person{

    private final double gpa;
    private final ArrayList<Course> courses;

    public Student(String name, double gpa, Course... courses) {
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

    public List<Course> getCourses(){
        return courses;
    }

    public void enrollCourse(Course course){
        CourseLibrary.getCourseLibrary().enrollStudent(this, course);
        courses.add(course);
    }

    public void dropStudent(Course course){
        CourseLibrary.getCourseLibrary().dropStudent(this, course);
        courses.remove(course);
    }




}
