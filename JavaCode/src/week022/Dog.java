package week022;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name) {
        super(name);
    }

//    public String toString() {
//        return this.speak() + ": " + super.toString();
//    }

    @Override
    public String speak() {
        return "汪汪汪";
    }

    @Override
    public void fuck() {

    }
}
