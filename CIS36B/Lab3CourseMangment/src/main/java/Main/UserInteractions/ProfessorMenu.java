package Main.UserInteractions;


import Main.People.Professor;

import java.util.Scanner;

public class ProfessorMenu implements Menu {

    @Override
    public void displayMenu() {
        System.out.println("1: Create Course");
        System.out.println("2: show All Courses");
    }

    @Override
    public Object handleResponse(Object... inputs) {
        Scanner scanner = new Scanner(System.in);
        Professor professor = (Professor) inputs[0];

        System.out.print("pick:");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1){
            System.out.print("name of course:");
            String name = scanner.nextLine();
            System.out.print("description of course:");
            String description = scanner.nextLine();
            System.out.print("credit hours:");
            int creditHours = Integer.parseInt(scanner.nextLine());
            System.out.print("max size:");
            int maxSize = Integer.parseInt(scanner.nextLine());
            professor.addClass(name, description, creditHours, maxSize);
        } else{
            professor.showClasses();
        }

        return null;
    }
}
