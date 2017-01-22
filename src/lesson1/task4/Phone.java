package lesson1.task4;

/**
 * Created by artem on 21.01.17.
 */

public class Phone {
    private String srcNumber;
    private Network network;

    public Phone() {}

    public Phone(String number) {
        setSrcNumber(number);
    }

    public void register() {
        String code = srcNumber.substring(0, 3);
        if(code.equals("093") || code.equals("063")) {
            network = new Life();
        } else if(code.equals("067") || code.equals("097")) {
            network = new Kyivstar();
        } else {
            System.out.println(String.format("Can't register number: %s. Unknown operator.", srcNumber));
            System.exit(1);
        }
        network.regNumber(this);
    }

    public void call(String destNumber) {
        System.out.println(String.format("Calling to %s", destNumber));
        network.call(srcNumber, destNumber);
    }

    public void receive(String caller) {
        System.out.println(String.format("Incoming call from: %s", caller));
    }

    public String getSrcNumber() {
        return srcNumber;
    }

    public void setSrcNumber(String srcNumber) {
        if (srcNumber.length() != 10 || !srcNumber.matches("[0-9]+")) {
            System.out.println(String.format("Number must have length 10 and contain only digits! Got number: %s", srcNumber));
            System.exit(1);
        }
        this.srcNumber = srcNumber;
    }

    @Override
    public String toString() {
        String networkFull = network.getClass().getName();
        String networkClass = networkFull.substring(networkFull.lastIndexOf('.') + 1);
        return "Phone{" +
                "number='" + srcNumber + '\'' +
                ", network=" + networkClass +
                '}';
    }
}
