package Lesson_1;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Box {
    String color;
  protected   String name;
    int weight;

    private String[] mass = {"Ivan", "Vasja"};

    public String[] getMass() {
        return mass;
    }

    public Box(String color, String name, int weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }

    public Box(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public void info() {
        System.out.println(Arrays.toString(mass));
    }

    public void info(int... a) {
        int res = 0;
        for (int x :a) {
            res += x;
        }
        System.out.println(res);
    }

    void startTest(Tools tools) {
        tools.testTools(this);
    }
}


class Tools {
    public Tools(String name) {
        this.name = name;
    }

    String name;

    void testTools(Box box) {
        box.name = "asd";
        System.out.println(name);
        box.info();
    }
}