package lesson3;

/**
 * Created by artem on 29.01.17.
 */

enum Gender {
    Man, Woman
}

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private Gender sex;

    public Human() {}

    public Human(String firstName, String lastName, int age, Gender sex) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSex(sex);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Can't set age. Age must be a positive integer.");
        }
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("first name is %s\nsecond name is %s\nage is %s\nsex is %s\n", firstName, lastName, age, sex);
    }
}
