package lesson1.task4;

import java.util.*;

/**
 * Created by artem on 22.01.17.
 */

public class Life extends Network {

    private static Map<String, Phone> numbers = new HashMap<>();

    @Override
    public void regNumber(Phone phone) {
        numbers.put(phone.getSrcNumber(), phone);
        System.out.println(String.format("Life registered phone number: %s", phone.getSrcNumber()));
    }

    @Override
    public void call(String srcNumber, String destNumber) {
        if (numbers.containsKey(destNumber)) {
            numbers.get(destNumber).receive(srcNumber);
        } else {
            System.out.println(String.format("Unregistered phone number in Life: %s", destNumber));
        }
    }
}
