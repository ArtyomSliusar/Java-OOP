package lesson1.task1;


/**
 * Created by artem on 17.01.17.
 */


public class Cat {
    //  Enum type
    private String name;
    private int age;
    private String type;
    private String color;
    private int livesCounter=12;

    public Cat() {}

    public Cat(String name, int age, String type, String color) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLivesCounter() {
        return livesCounter;
    }

    public void setLivesCounter(int livesCounter) {
        this.livesCounter = livesCounter;
    }


}