package Lesson_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Box box = new Box("red", "box1", 10);
//       // box.info();
//        Tools tools = new Tools("tools_1");
//        box.startTest(tools);

//        box.info(2,2, 5,5,10,15,20);
//        box.info(2,20);
//        box.info(2);
      // abc();

//        Box[] boxes = {new Box("red", "box1", 10), new Box("red", "box1", 10)};
//        boxes[0].weight = 10;
//        boxes[1].weight = 15;
//
//        boxes[0].info();
//        boxes[1].info();

     //   Box box1 = new Box("red", "box1", 10);

        //box1.setMass(new String []{"asd", "asd"});
//        box1.info();
//        String[] mass = box1.getMass();
//        mass[0] = "asdsad";
//        box1.info();
        int a = 10;
        test1(a);
        System.out.println(a);

        StringBuilder stringBuilder = new StringBuilder("Hello");
        String str = "Hello";
        test2(stringBuilder);
        System.out.println(stringBuilder.toString());

        int[] mass = {1,2,3};
        test3(mass);
        System.out.println(Arrays.toString(mass));

    }

    static void test1(int a) {
        a++;
    }

    static void test2(StringBuilder str) {
        str.append("1");
    }

    static void test3(int[] mass) {
        mass[0] = 10;
    }

    static void abc() {
        System.out.println("abc");
    }

}
