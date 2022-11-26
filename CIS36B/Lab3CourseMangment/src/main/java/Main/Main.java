package Main;

import Main.Course.Course;
import Main.Course.CourseLibrary;
import Main.People.Person;
import Main.People.Professor;
import Main.People.Student;
import Main.UserInteractions.MainMenu;
import Main.UserInteractions.ProfessorMenu;
import Main.UserInteractions.StudentMenu;

public class Main {
    public static void main(String[] args) {

        CourseLibrary.getCourseLibrary().addClass(new Course("Calculus 1", "first calculus class", 5, 32, new Professor("kittu")));
        CourseLibrary.getCourseLibrary().addClass(new Course("English 1", "first english class", 5, 32, new Professor("kittu")));




        MainMenu mainMenu = new MainMenu();

        mainMenu.displayMenu();
        Person person = (Person) mainMenu.handleResponse();

        if (person instanceof Professor){
            while (true) {
                ProfessorMenu professorMenu = new ProfessorMenu();
                professorMenu.displayMenu();
                professorMenu.handleResponse((Professor) person);
            }
        } else if (person instanceof Student) {
            while (true) {
                StudentMenu studentMenu = new StudentMenu();
                studentMenu.displayMenu();
                studentMenu.handleResponse((Student) person);
            }
        }
    }
}