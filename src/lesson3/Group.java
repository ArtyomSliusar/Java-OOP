package lesson3;

import java.util.Arrays;

/**
 * Created by artem on 29.01.17.
 */

public class Group {
    private Student[] students = new Student[10];

    public Group() {}

    public Group(Student[] students) {
        for(Student student: students) {
            addStudent(student);
        }
    }

    public void addStudent(Student newStudent) throws GroupFullException {
        for(int i=0; i<students.length; i++) {
            if(students[i] == null) {
                students[i] = newStudent;
                System.out.println(String.format("Student (%s %s %s %s) was added to the group.", newStudent.getFirstName(),
                        newStudent.getLastName(), newStudent.getAge(), newStudent.getSex()));
                return;
            }
        }
        throw new GroupFullException();
    }

    public void removeStudent(Student student) {
        for(int i=0; i<students.length; i++) {
            if(students[i] == student) {
                students[i] = null;
                System.out.println(String.format("Student (%s %s %s %s) was deleted from the group.", student.getFirstName(),
                        student.getLastName(), student.getAge(), student.getSex()));
                return;
            }
        }
        System.out.println(String.format("Student (%s %s %s %s) is not in the group.", student.getFirstName(),
                student.getLastName(), student.getAge(), student.getSex()));
    }

    public Student findByLastName(String lastName) {
        for(int i=0; i<students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                System.out.println(String.format("Student with last name %s was found.", lastName));
                return students[i];
            }
        }
        System.out.println(String.format("Student with last name %s was not found.", lastName));
        return null;
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
}
