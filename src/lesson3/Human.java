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
        if(firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        } else {
            System.out.println("Can't set first name. First name can't be empty.");
            System.exit(1);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        } else {
            System.out.println("Can't set last name. Last name can't be empty.");
            System.exit(1);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Can't set age. Age must be a positive integer.");
            System.exit(1);
        } else {
            this.age = age;
        }
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("Human: first name is %s; second name is %s; age is %s; sex is %s", firstName, lastName, age, sex);
    }
}
