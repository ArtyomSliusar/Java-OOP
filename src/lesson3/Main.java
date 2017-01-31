package lesson3;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by artem on 23.01.17.
 */

public class Main {
    public static void main(String[] args) {
        Student h1 = new Student("Ivan", "Ivanov", 25, Gender.Man);
        Student h2 = new Student("Ivan2", "Ivanov", 25, Gender.Man);
        Student h3 = new Student("Ivan3", "Ivanov", 25, Gender.Man);
        Student h4 = new Student("Ivan", "Ivanov", 25, Gender.Man);
        Student h5 = new Student("Ivan2", "Ivanov", 25, Gender.Man);
        Student h6 = new Student("Ivan3", "Ivanov", 25, Gender.Man);
        Student h7 = new Student("Ivan", "Ivanov", 25, Gender.Man);
        Student h8 = new Student("Ivan2", "Ivanov", 25, Gender.Man);
        Student h9 = new Student("Ivan3", "Ivanov", 25, Gender.Man);
        Student h10 = new Student("Ivan", "Ivanov", 25, Gender.Man);
        Student h11 = new Student("Ivan2", "Ivanov", 25, Gender.Man);

        Group g1 = new Group(new Student[]{h1, h2, h3, h4, h5, h6, h7, h8, h9, h10});
        g1.removeStudent(h10);
    }
}
