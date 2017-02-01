package lesson3;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by artem on 23.01.17.
 */

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ivan", "Ivanov", 25, Gender.Man);
        Student s2 = new Student("Bodya", "Ivanov", 18, Gender.Man);
        Student s3 = new Student("Kolya", "Ivanov", 25, Gender.Man);
        Student s4 = new Student("Grisha", "Ivanov", 39, Gender.Man);
        Student s5 = new Student("Vanya", "Ivanov", 25, Gender.Man);
        Student s6 = new Student("Sofia", "Ivanov", 26, Gender.Woman);
        Student s7 = new Student("Misha", "Ivanov", 14, Gender.Man);
        Student s8 = new Student("Artem", "Ivanov", 25, Gender.Man);
        Student s9 = new Student("Andrey", "Ivanov", 17, Gender.Man);
        Student s10 = new Student("Stewart", "Ivanov", 25, Gender.Man);
        Student s11 = new Student();
        s11.setFirstName("Lilu");
        s11.setLastName("Ivanov");
        s11.setSex(Gender.Woman);
        s11.setAge(19);

        Group g1 = new Group();
        try {
            g1 = new Group(new Student[]{s1, s2, s3, s4, s5, s6, s7, s8, s9});
            g1.addStudent(s10);
            g1.removeStudent(s1);
            g1.addStudent(s11);
            g1.addStudent(s1);
        }
        catch (GroupFullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(g1);
        }
    }
}
