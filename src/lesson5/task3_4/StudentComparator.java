package lesson5.task3_4;
import java.util.Arrays;

/**
 * Created by artem on 06.02.17.
 */

public class StudentComparator {

    public static void sortByLastName(Student[] students) {
        Arrays.sort(students, (a, b)->
                checkNull(a, b)==2?a.getLastName().compareTo(b.getLastName()):checkNull(a, b));
    }

    public static void sortByFirstName(Student[] students) {
        Arrays.sort(students, (a, b)->
                checkNull(a, b)==2?a.getFirstName().compareTo(b.getFirstName()):checkNull(a, b));
    }

    public static void sortByAge(Student[] students) {
        Arrays.sort(students, (a, b)->
                checkNull(a, b)==2?Integer.compare(a.getAge(), b.getAge()):checkNull(a, b));
    }

    public static void sortByCourse(Student[] students) {
        Arrays.sort(students, (a, b)->
                checkNull(a, b)==2?Integer.compare(a.getCourse(), b.getCourse()):checkNull(a, b));
    }

    private static int checkNull(Object a, Object b) {
        if ((a != null) && (b == null)) {
            return -1;
        }
        if ((a == null) && (b != null)) {
            return 1;
        }
        if ((a == null) && (b == null)) {
            return 0;
        }
        return 2;
    }

}
