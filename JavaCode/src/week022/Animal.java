package week022;

// Access Modifier
// - public
// - private
// - protected (package OR child)
// - default (package only)


// abstract class:
//  - 100% same as a regular class
//  - ONLY different:
//      - Cannot instantiate this class
//        不能 ... = new Animal(...);
//      - CAN have abstract methods
public abstract class Animal implements Fuckable {

    // static member belong to the class itself,
    // all objects (instances) share the same static value
    public static int numberOfAnimals = 0;

    // Fields, Attributes, Instance variable
    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfAnimals++;
    }

    // Method Overload
    // - same return type
    // - same method name
    // - diff params types OR
    //   diff number of params

    public Animal(String name) {
        // 去叫 上面那個 constructor
        this(name, 1);
    }

    // Accessors
    // setters/getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.speak() + ": " + this.name + " " + this.age;
    }

    // abstract method:
    //  - 只有 method header.
    //  - 任何 child class 都必須 完成(implement) 這個 method 的 body
    public abstract String speak();

}
