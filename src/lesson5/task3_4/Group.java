package lesson5.task3_4;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by artem on 29.01.17.
 */

public class Group implements Voenkom, Serializable {
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
                System.out.println(String.format("Added | %s.", newStudent));
                return;
            }
        }
        throw new GroupFullException();
    }

    public void removeStudent(Student student) {
        for(int i=0; i<students.length; i++) {
            if(students[i] == student) {
                students[i] = null;
                System.out.println(String.format("Removed | %s.", student));
                return;
            }
        }
        System.out.println(String.format("Can't remove, not found | %s.", student));
    }

    public Student findByLastName(String lastName) {
        for(int i=0; i<students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                System.out.println(String.format("Found by last name '%s'.", lastName));
                return students[i];
            }
        }
        System.out.println(String.format("Not found by last name '%s'.", lastName));
        return null;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        String group = "Group:\n";
        for(Student student: this.students) {
            if(student != null){
                group += student.toString()+"\n";
            }
        }
        return group;
    }

    @Override
    public Student[] returnStudents() {
        StudentComparator.sortByAge(this.students);
        Student[] studentsToArmy;
        for (int i=0; i<this.students.length; i++) {
            if(this.students[i].getAge() > serveAge) {
                studentsToArmy = Arrays.copyOfRange(this.students, i, this.students.length+1);
                for (int j=i; j<this.students.length; j++) {
                    this.students[j] = null;
                }
                return studentsToArmy;
            }
        }
        return null;
    }
}
