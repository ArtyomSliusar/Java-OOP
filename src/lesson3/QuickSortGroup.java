package lesson3;

/**
 * Created by artem on 31.01.17.
 */

public class QuickSortGroup {

    public static void quickSort(Student[] group) {
        int startIndex = 0;
        int endIndex = group.length - 1;
        doSortByFirstName(startIndex, endIndex, group);
    }

    private static void doSortByFirstName(int start, int end, Student[] group) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (group[i].getFirstName().compareToIgnoreCase(group[cur].getFirstName()) <= 0)) {
                i++;
            }
            while (j > cur && (group[cur].getFirstName().compareToIgnoreCase(group[j].getFirstName()) <= 0)) {
                j--;
            }
            if (i < j) {
                Student temp = group[i];
                group[i] = group[j];
                group[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortByFirstName(start, cur, group);
        doSortByFirstName(cur+1, end, group);
    }
}