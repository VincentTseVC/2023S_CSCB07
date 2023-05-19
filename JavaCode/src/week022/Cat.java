package week022;


public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat(String name) {
        super(name);
    }

//    public String toString() {
//        return this.speak() + ": " + super.toString();
//    }

    @Override
    public String speak() {
        return "喵喵喵";
    }

    @Override
    public void fuck() {

    }
}
