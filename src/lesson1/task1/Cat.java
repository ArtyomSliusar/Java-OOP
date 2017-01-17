package lesson1.task1;


/**
 * Created by artem on 17.01.17.
 */


enum CatBreeds {
    Bengal, Bombay, Bobtail
}


public class Cat {
    private String name;
    private int age;
    private CatBreeds type;
    private String color;
    private int weight;

    public Cat() {}

    public Cat(CatBreeds type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public CatBreeds getType() {
        return type;
    }

    public void setType(CatBreeds type) {
        if (this.type == null) {
            this.type = type;
        } else {
            System.out.println("You can't change cat's breed after it's set.");
        }
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    public void feed(String meal) {
        switch (meal) {
            case "mouse":
                this.weight += 5;
                break;
            case "whiskas":
                this.weight += 3;
                break;
            case "vegetables":
                this.weight += 2;
                break;
            default:
                this.weight += 1;
                break;
        }
        System.out.println(String.format("Cat %s ate %s.", this.name, meal));
    }

    public void voice() {
        System.out.println(String.format("%s meow!", this.name));
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}