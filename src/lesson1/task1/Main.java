package lesson1.task1;


/**
 * Created by artem on 17.01.17.
 */


public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat(CatBreeds.Bombay);
        catOne.setColor("black");
        catOne.setAge(2);
        catOne.setName("Murzik");
        catOne.setWeight(2);

        Cat catTwo = new Cat(CatBreeds.Bengal);
        catTwo.setColor("white");
        catTwo.setAge(5);
        catTwo.setName("Pushok");
        catTwo.setWeight(4);

        Cat catThree = new Cat();
        catThree.setType(CatBreeds.Bobtail);
        catThree.setColor("red");
        catThree.setAge(3);
        catThree.setName("Ruzuk");
        catThree.setWeight(3);

        catOne.feed("meat");
        catOne.feed("mouse");
        catTwo.feed("whiskas");
        catThree.feed("vegetables");

        catOne.voice();
        catTwo.voice();
        catThree.voice();

        System.out.println(catOne);
        System.out.println(catTwo);
        System.out.println(catThree);
    }

}