package lesson8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by artem on 08.02.17.
 */

public class Main {
    public static void main(String[] args) {
        Point a = new Point(0,0);
        Line lineOne = new Line(a, new Point(5, 5));
        Line lineTwo = null;
        try {
            lineTwo = lineOne.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(lineOne);
        System.out.println(lineTwo);

        if(lineOne==lineTwo) {
            System.out.println("Same");
        } else {
            System.out.println("Diff");
        }

        lineTwo.getEnd().setX(10);
        System.out.println(lineOne);
        System.out.println(lineTwo);

        Class<?> classOne = Line.class;  // OR Class<?> classOne = lineOne.getClass();
        Field[] fieldArray = classOne.getDeclaredFields();

        for(Field field: fieldArray) {
            String type = field.getType().isPrimitive() ? "Primitive" : "Linked";
            System.out.println(type + " -> " + field);
        }

        Method[] methodArray = classOne.getDeclaredMethods();
        for (Method method: methodArray) {
            System.out.println(method);
        }

        Constructor[] constructorArray = classOne.getDeclaredConstructors();
        for (Constructor constructor: constructorArray) {
            System.out.println(constructor);
        }
    }
}
