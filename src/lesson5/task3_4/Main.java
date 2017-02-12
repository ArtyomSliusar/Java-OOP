package lesson5.task3_4;
import java.util.Scanner;

/**
 * Created by artem on 23.01.17.
 */

public class Main {
    public static void main(String[] args) throws IncorrectInputException {
        Group g1 = new Group();

        if(isInputManual()) {
            ManualInput.editGroup(g1);
        } else {
            Student s1 = new Student("Ivan", "Kfds", 25, Gender.Man, 1, "history");
            Student s2 = new Student("Bodya", "Qqwer", 18, Gender.Man, 2, "math");
            Student s3 = new Student("Kolya", "Dfdsf", 25, Gender.Man, 3, "");
            Student s4 = new Student("Grisha", "Fgfhgh", 39, Gender.Man, 5, "");
            Student s5 = new Student("Vanya", "Lfdng", 25, Gender.Man, 3, "");
            Student s6 = new Student("Sofia", "Uertre", 26, Gender.Woman, 4, "");
            Student s7 = new Student("Misha", "Sdfds", 14, Gender.Man, 2, "");
            Student s8 = new Student("Artem", "Efdgdf", 25, Gender.Man, 1, "all");
            Student s9 = new Student("Andrey", "Tdfgdf", 17, Gender.Man, 5, "");
            Student s10 = new Student("Stewart", "Ivanov", 25, Gender.Man, 3, "");

            Student s11 = new Student();
            s11.setFirstName("Lilu");
            s11.setLastName("Ivanov");
            s11.setSex(Gender.Woman);
            s11.setAge(19);
            s11.setCourse(2);
            s11.setFavoriteSubject("literature");

            try {
                g1 = new Group(new Student[]{s1, s2, s3, s4, s5, s6, s7, s8, s9});

                Voenkom voenkom = g1;
                Student[] studentsToArmy = voenkom.returnStudents();
                if(studentsToArmy.length > 1) {
                    System.out.println("\nThey are going to the army:");
                    for (Student student: studentsToArmy) {
                        if(student != null) {
                            System.out.println(student);
                        }
                    }
                }
                System.out.println("");
                g1.addStudent(s10);
                g1.removeStudent(s1);
                g1.addStudent(s11);
                g1.addStudent(s1);
            }
            catch (GroupFullException e) {
                System.out.println(e.getMessage());
            }
            finally {
                StudentComparator.sortByLastName(g1.getStudents());
                System.out.println(g1);
            }
        }
    }

    private static boolean isInputManual() {
        String answer;
        boolean isManual;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Manual input? [y/n]");
            answer = in.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                isManual = true;
                break;
            } else if (answer.equals("n")) {
                isManual = false;
                break;
            } else {
                System.out.println("Please answer y/n");
            }
        }
        return isManual;
    }
}
