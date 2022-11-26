package Main.UserInteractions;

import Main.Course.Course;
import Main.Course.CourseLibrary;
import Main.People.Student;

import java.util.List;
import java.util.Scanner;

public class StudentMenu implements Menu {
    @Override
    public void displayMenu() {
        System.out.println("1: Search classes");
        System.out.println("2: enroll in Course");
        System.out.println("3: drop a Course");
        System.out.println("4: show all enrolled classes");
    }

    @Override
    public Object handleResponse(Object... inputs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("choice:");
        int choice = Integer.parseInt(scanner.nextLine());

        Student student = (Student) inputs[0];

        if (choice == 1) {
            System.out.println("search for course, name, description, or professor name:");
            String search = scanner.nextLine();

            List<Course> courseList = CourseLibrary.getCourseLibrary().search(search);

            for (Course course : courseList) {
                System.out.println(course.toString());
            }
        } else if (choice == 2) {
            List<Course> allCourses = CourseLibrary.getCourseLibrary().getAllCourses();

            printListHandleChoice(scanner, student, allCourses);
        } else if (choice == 3) {
            List<Course> enrolledCourses = student.getCourses();
            printListHandleChoice(scanner, student, enrolledCourses);
        } else {
            student.showRegistration();
        }

        return null;
    }

    private void printListHandleChoice(Scanner scanner, Student student, List<Course> allCourses) {
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.println((i + 1) + allCourses.get(i).toString());
        }

        System.out.print("course #:");
        int courseNumber = scanner.nextInt();
        student.enrollCourse(allCourses.get(courseNumber - 1));
    }
}
