package lesson4;

import java.util.Scanner;

/**
 * Created by artem on 07.02.17.
 */

public class ManualInput {
    public static void editGroup(Group group) {
        String choice = "0";
        Scanner reader = new Scanner(System.in);

        while (!choice.equals("q")) {
            printMenu();
            System.out.println("Make your choice: ");
            choice = reader.nextLine().trim().toLowerCase();

            switch(choice) {
                case "1":
                    manualAddStudent(group);
                    break;
                case "2":
                    manualRemoveStudent(group);
                    break;
                case "3":
                    displayGroup(group);
                    break;
                case "4":
                    sortGroup(group);
                    break;
                case "q":
                    System.out.println("Good bye");
                    System.exit(0);
                default:
                    System.out.println("Invalid input...");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Add student\n" +
                            "2. Remove student\n" +
                            "3. Display group\n" +
                            "4. Sort group\n" +
                            "q. Quit");
    }

    private static void printSortMenu() {
        System.out.println("1. Sort by first name\n" +
                "2. Sort by last name\n" +
                "3. Sort by age\n" +
                "4. Sort by course\n" +
                "5. Return");
    }

    private static void enterStringParam(Scanner reader, Student s, String paramType) {
        while (true) {
            System.out.println(String.format("Enter %s:", paramType));
            try {
                if(paramType.equals("first name")) {
                    String name = reader.nextLine();
                    s.setFirstName(name);
                } else if(paramType.equals("last name")) {
                    String name = reader.nextLine();
                    s.setLastName(name);
                } else if(paramType.equals("favorite subject")) {
                    String subject = reader.next();
                    s.setFavoriteSubject(subject);
                } else {
                    System.out.println("Unknown string param: " + paramType);
                    System.exit(1);
                }
                break;
            } catch (IncorrectInputException e) {
            }
        }
    }

    private static void enterIntParam(Scanner reader, Student s, String paramType) {
        while (true) {
            System.out.println(String.format("Enter %s:", paramType));
            if(!reader.hasNextInt()) {
                System.out.println("Int, please.");
                reader.next();
                continue;
            }
            try {
                int val = reader.nextInt();
                if(paramType.equals("age")) {
                    s.setAge(val);
                } else if(paramType.equals("course")) {
                    s.setCourse(val);
                } else {
                    System.out.println("Unknown int param: " + paramType);
                    System.exit(1);
                }
                break;
            }
            catch (IncorrectInputException e) {}
        }
    }

    private static void manualAddStudent(Group group) {
        Scanner reader = new Scanner(System.in);
        Student s = new Student();
        enterStringParam(reader, s, "first name");
        enterStringParam(reader, s, "last name");
        enterIntParam(reader, s, "age");
        Gender sexGender;
        while (true) {
            System.out.println("Enter sex:");
            String sex = reader.next().toLowerCase();
            if(sex.equals("man")) {
                sexGender = Gender.Man;
                s.setSex(sexGender);
                break;
            } else if(sex.equals("woman")) {
                sexGender = Gender.Woman;
                s.setSex(sexGender);
                break;
            } else {
                System.out.println("Wrong sex. Enter man or woman.");
            }
        }
        enterIntParam(reader, s, "course");
        enterStringParam(reader, s, "favorite subject");
        group.addStudent(s);
    }

    private static void manualRemoveStudent(Group group) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter last name or 0 to return:");
            String lastName = reader.nextLine();
            if(lastName.equals("0")) {
                editGroup(group);
            }
            if(!lastName.isEmpty()) {
                Student student = group.findByLastName(lastName);
                if(student != null) {
                    group.removeStudent(student);
                }
            }
        }
    }

    private static void displayGroup(Group group) {
        System.out.println(group);
    }

    private static void sortGroup(Group group) {
        Scanner reader = new Scanner(System.in);
        String choice = "0";
        Student[] students = group.getStudents();

        while (!choice.equals("5")) {
            printSortMenu();
            System.out.println("Make your choice: ");
            choice = reader.nextLine().trim().toLowerCase();
            switch (choice) {
                case "1":
                    StudentComparator.sortByFirstName(students);
                    break;
                case "2":
                    StudentComparator.sortByLastName(students);
                    break;
                case "3":
                    StudentComparator.sortByAge(students);;
                    break;
                case "4":
                    StudentComparator.sortByCourse(students);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid input...");
            }
        }
        editGroup(group);
    }
}
