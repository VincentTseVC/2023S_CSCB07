package week02;

import week022.Animal;
import week022.Cat;
import week022.Dog;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello world");

        // Primitive Type (value type)
        int a = 65;             // 4 bytes, 32 bits => 2^32 -> 21,41
        float f = 1;
        double d = 3.14159;
        long l = 10000000;
        boolean b = true;
        char c = 'A'; // 65
        short s = 259;          // 2 bytes, 16 bits

        int z = s;
        // 259 -> 256 + 2 + 1

        // s -> 0000 0001  0000 0011
        // z -> 0000 0000  0000 0000  0000 0001  0000 0011

        byte b1 = (byte) s;
        // s  -> 0000 0001  0000 0011
        // b1 -> 0000 0011

        System.out.println(s);
        System.out.println(z);
        System.out.println(b1);

        System.out.println(a == c);

        // Reference Type (object Type)
        // Think as a compound data type in c (struct)
        // has different fields, and methods, not just a value
        // it is created in the "HEAP", using something like ... calloc()
        // ** variable store the "memory address of the object"

        String s1 = new String("CSCB07");
        String s2 = new String("CSCB07");

        String s3 = "CSCB07"; // short-cut of creating a string, put in to 'String-pool'
        String s4 = "CSCB07"; // java will first check 'String-pool', 沒有才create

        // same object? same memory address?
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        // same content?
        System.out.println(s1.equals(s2));

        Integer int1 = 5;   // auto-boxing
        int k = int1;       // auto-unboxing
        Integer int2 = new Integer(5); // no auto-boxing


        // --------------------

        System.out.println(Animal.numberOfAnimals); // 0

        Cat mua = new Cat("Mua", 3);
        System.out.println(Animal.numberOfAnimals); // 1

        System.out.println(mua.getName());
        System.out.println(mua.getAge());
        mua.setAge(4);

        Cat mimi = new Cat("Mimi");
        System.out.println(Animal.numberOfAnimals);  // 2


        Dog paco = new Dog("Paco");

        System.out.println(mua);   // mua.toString()
        System.out.println(paco);  // paco.toString()

        // Polymorphism
        Animal[] pets = {mua, mimi, paco};

        for (int i = 0; i < pets.length; i++)
            System.out.println(pets[i].speak());

        for (Animal p: pets)
            System.out.println(p.speak());

    }
}
