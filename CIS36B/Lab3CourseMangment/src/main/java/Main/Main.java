package Main;

import Main.Course.Course;
import Main.Course.CourseLibrary;
import Main.People.Professor;

public class Main {
    public static void main(String[] args) {
        CourseLibrary library = CourseLibrary.getCourseLibrary();

        library.addClass(new Course("Calculus 1", "first calculus class", 5, 32, new Professor("kittu")));
        library.addClass(new Course("Calculus 2", "second calculus class", 5, 32, new Professor("kittu")));


        System.out.println(library.search("First calculus class"));
        System.out.println(library.search("second calculus clas"));
    }
}