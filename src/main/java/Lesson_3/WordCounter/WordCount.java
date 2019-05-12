package Lesson_3.WordCounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WordCount {

    /**
     * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
     *
     */

    /**
     * Метод разбивает входящую строку на список слов
     * @param baseSentence
     * @return
     */
    static String[] splitToWords(String baseSentence) {
        String [] ret = baseSentence.split("\\s");
        return ret;
    }

    static HashMap<String, Integer> countWords(String [] ll) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String word : ll) {
            String clean = word.replaceAll("[,\\)\\.\\(]+$|^[,\\)\\.\\(]+", "");
            String lower_clean = clean.toLowerCase();
            hm.merge(lower_clean, 1, Integer::sum);
        }
        return hm;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = countWords(splitToWords("Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово. И потом Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны."));

        for (Map.Entry<String, Integer> kv : hm.entrySet()) {
            System.out.println( kv.getKey() + ": "+kv.getValue());
        }

    }
}
