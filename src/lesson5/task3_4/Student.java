package lesson5.task3_4;

import java.io.Serializable;

/**
 * Created by artem on 29.01.17.
 */

public class Student extends Human implements Comparable, Serializable {
    private int course;
    private String favoriteSubject="None";

    public Student() {}

    public Student(String firstName, String lastName, int age, Gender sex, int course, String favoriteSubject) throws IncorrectInputException {
        super(firstName, lastName, age, sex);
        setCourse(course);
        setFavoriteSubject(favoriteSubject);
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) throws IncorrectInputException {
        if(course >= 1 && course <= 5) {
            this.course = course;
        }
        else {
            System.out.println("Can't set course " + course + ". Course must be from 1 to 5.");
            throw new IncorrectInputException();
        }
    }

    public String getFavoriteSubject() {
        return favoriteSubject;
    }

    public void setFavoriteSubject(String favoriteSubject) {
        if(favoriteSubject != null && !favoriteSubject.isEmpty()) {
            this.favoriteSubject = favoriteSubject;
        }
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("Human:", "Student:") + String.format("; course is %s; fav.subject is %s",
                this.course, this.favoriteSubject);
    }

    // NOTE: shouldn't be used for array with NULL
    @Override
    public int compareTo(Object o) {
        if(o == null) {
            return -1;
        }
        Student anotherStudent = (Student) o;
        return this.getLastName().compareToIgnoreCase(anotherStudent.getLastName());
    }
}
