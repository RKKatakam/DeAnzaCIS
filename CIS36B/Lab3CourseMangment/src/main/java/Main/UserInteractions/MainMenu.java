package Main.UserInteractions;

import Main.People.Person;
import Main.People.Professor;
import Main.People.Student;

import java.util.Scanner;

public class MainMenu implements Menu {

    @Override
    public void displayMenu() {
        System.out.print("are you a professor (1) or a student(2):");
    }

    @Override
    public Object handleResponse( Object... inputs) {
        Scanner scanner = new Scanner(System.in);

        int choice =  Integer.parseInt(scanner.nextLine());

        System.out.println("what is your name:");
        String name = scanner.nextLine();
        Person person = null;

        if (choice == 1){
            Professor professor = new Professor(name);
            System.out.println("successful creation");
            person = professor;
        }else if (choice == 2){
            Student student = new Student(name, 0);
            System.out.println("successful creation");
            person = student;
        }

        return person;
    }
}
