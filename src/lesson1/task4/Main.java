package lesson1.task4;

/**
 * Created by artem on 22.01.17.
 */

public class Main {
    public static void main(String[] args) {
        Phone phoneOne = new Phone("0932358988");
        Phone phoneTwo = new Phone("0638965749");
        Phone phoneThree = new Phone("0975684265");
        Phone phoneFour = new Phone("0678564364");

        phoneOne.register();
        phoneTwo.register();
        phoneThree.register();
        phoneFour.register();

        phoneOne.call("0638965749");
        phoneOne.call("0975684265");
        phoneThree.call("0678564364");

        System.out.println(phoneOne);
        System.out.println(phoneThree);
    }
}
