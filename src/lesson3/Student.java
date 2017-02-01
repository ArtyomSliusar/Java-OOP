package lesson3;

/**
 * Created by artem on 29.01.17.
 */

public class Student extends Human {

    public Student() {}

    public Student(String firstName, String secondName, int age, Gender sex) {
        super(firstName, secondName, age, sex);
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("Human:", "Student:");
    }
}
