package Lesson_1;

public abstract class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void voice();

    void test() {
        System.out.println("asdsa");
    }
}

class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    void test() {
        super.name = "sdf";
    }

    @Override
    void voice() {
        System.out.println("Собака издала звук!");
    }

}

class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void voice() {
      //  super.voice();
        System.out.println("мяу!!");
    }
}

class MainAnimal {
    public static void main(String[] args) {
//        final int a = 0;
//        a++;
//        Animal animal = new Animal("red", 10);
//        animal.name = "asd";
//
//        Dog dog = new Dog("asdqwe", 5);
//        dog.name = "aasdsad";
//
//        System.out.println(animal.name + " " + dog.name);

//        Animal[] mass = {new Animal("name_1", 10), new Dog("name_2", 5),
//        new Cat("name_3", 2)};
//
//        for (Animal a: mass) {
//            a.voice();
//        }


    }
}
