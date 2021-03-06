package lesson3;

/**
 * Created by artem on 29.01.17.
 */

public class Student extends Human {
    private int course;
    private String favoriteSubject="None";

    public Student() {}

    public Student(String firstName, String secondName, int age, Gender sex, int course, String favoriteSubject) {
        super(firstName, secondName, age, sex);
        setCourse(course);
        setFavoriteSubject(favoriteSubject);
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if(course >= 1 && course <= 5) {
            this.course = course;
        }
        else {
            System.out.println("Can't set course " + course + ". Course must be from 1 to 5.");
            System.exit(1);
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
}
