package lesson1.task3;

import java.util.Arrays;

/**
 * Created by artem on 18.01.17.
 */

public class Main {
    public static void main(String[] args) {
        Vector3D vectorOne = new Vector3D(new double[]{1.0,1.0,2.0}, new double[]{3.0,1.0,4.0});
        Vector3D vectorTwo = new Vector3D(new double[]{2.0,1.0,2.0}, new double[]{1.0,1.0,2.0});

        System.out.println(String.format("Add vectors:\n %s\n %s", vectorOne, vectorTwo));
        System.out.println(String.format("Result: %s\n", vectorOne.add(vectorTwo)));
        System.out.println(String.format("Scalar of vectors:\n %s\n %s", vectorOne, vectorTwo));
        System.out.println(String.format("Result: %s\n", vectorOne.scalarProd(vectorTwo)));
        System.out.println(String.format("Multiplication of vectors:\n %s\n %s", vectorOne, vectorTwo));
        System.out.println(String.format("Result: %s\n", Arrays.toString(vectorOne.vectorProd(vectorTwo))));
    }
}
