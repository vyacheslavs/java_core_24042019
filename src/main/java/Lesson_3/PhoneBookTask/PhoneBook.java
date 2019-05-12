package Lesson_3.PhoneBookTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {

    private HashMap<String, LinkedList<String> > book_registry;

    PhoneBook() {
        book_registry = new HashMap<>();
    }

    LinkedList<String> accumulate(LinkedList<String> val, String ... phone) {
        val.addAll(Arrays.asList(phone));
        return val;
    }

    public void add(String surname, String ... phone_number) {
        if (phone_number==null)
            return;

        book_registry.compute(surname, (key, val) -> (val == null) ?
                new LinkedList<String>(Arrays.asList(phone_number)) :
                accumulate(val, phone_number));
    }

    public LinkedList<String> get(String surname) {
        return book_registry.get(surname);
    }
}
