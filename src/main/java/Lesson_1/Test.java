package Lesson_1;

public class Test {
}



//  1  Что произойдет после компиляции кода и запуска программы без аргументов:
//
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println(args.length);
//    }
//}















//  2  Как можно уничтожить объект в Java?
//
//        1. присвоить null всем ссылкам на объект
//        2. вызвать Runtime.getRuntime().gc()
//        3. вызвать метод finalize() у объекта
//        4. этого нельзя сделать вручную
//        5. вызвать деструктор у объекта




















//   3 Каким будет результат компиляции и выполнения данного кода:
//
//
//public class Switch {
//    public static void main(String[] args) {
//        int i = 3;
//        switch(i) {
//            default:
//                System.out.println("default");
//            case 1:
//                System.out.println("1");
//            case 2:
//                System.out.println("2");
//        }
//    }
//}





















//
//  4   Перечислите все валидные сигнатуры конструкторов класса Clazz:
//
//        Clazz(String name)
//        Clazz Clazz(String name)
//        int Clazz(String name)
//        void Clazz(String name)
//        Clazz(name)
//        Clazz()


















//  5   Скомпилируется ли следующий код, если оба класса будут объявлены в файле Test.java?
//
//
////Test.java
//public class Car{
//    public String myCar = "Ferrari" ;
//}
//public class Test{
//    public static void main(String ... args){
//        Car myCar = new Car();
//        System.out.println(myCar.myCar);
//    }
//}

















//  6  Какие два интерфейса предоставляют возможность хранить объекты в виде пары "ключ-значение"?
//
//        java.util.Map
//        java.util.List
//        java.util.Set
//        java.util.SortedSet
//        java.util.SortedMap
//        java.util.Collection











// 7   Перечислите все методы, которые есть у класса Object.
//
//        equals
//        toString
//        hashCode
//        clone









//  8  ////////////////
//    Что будет напечатано после попытки компиляции и выполнения кода:
//        int[] mass = {1, 2};
//        List<String> list = new ArrayList(10);
//        list.add("03");
//        list.add("04");
//        System.out.println(mass.length + list.size() + ".");
















// 9
//class Test4 {
//    public static void main(String[] args) {
//        boolean b = true;
//        int x = 0;
//
//        do {
//            if(x++ > 5)
//                b = false;
//            System.out.print(x);
//        } while (b);
//
//    }
//}



















//// 10 если класс абстрактный то наследнику обязательно реализовывать абстрактные методы родителя