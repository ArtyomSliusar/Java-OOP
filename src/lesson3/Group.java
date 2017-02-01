package lesson3;

import java.lang.reflect.Array;
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
                System.out.println(String.format("%s was added to the group.", newStudent));
                return;
            }
        }
        throw new GroupFullException();
    }

    public void removeStudent(Student student) {
        for(int i=0; i<students.length; i++) {
            if(students[i] == student) {
                students[i] = null;
                System.out.println(String.format("%s was deleted from the group.", student));
                return;
            }
        }
        System.out.println(String.format("%s can't be removed. He is not in the group.", student));
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
        String group = "Group:\n";
        QuickSortGroup.quickSort(this.students);
        for(int i=0; i<this.students.length; i++) {
            group += this.students[i].toString()+"\n";
        }
        return group;
    }
}
