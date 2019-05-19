package Lesson_3.PasswordChecker;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Создать метод для проверки пароля
 *
 * 1 Обязательно есть хоть 1 цифра
 * 2 Не менее 8 символов и не более 20
 * 3 Должны быть большие и маленькие буквы
 * 4 Обязательно дожен быть спец символ
 */

public class PassCheck {

    public static HashSet<Character> password_special_letters = new HashSet<Character>(Arrays.asList('@','%','+','\\','/','\'','!','#','$','^','?',':','.','(',')','{','}','[',']','~','-','_'));


    public static boolean checkPassword(String pwd) {

        // Не менее 8 символов и не более 20
        if (!(pwd.length() >= 8 && pwd.length()<=20))
            return false;

        int has_numeric = 0;
        int has_small_letters = 0;
        int has_big_letters = 0;
        int has_special_letters = 0;

        for (char ch : pwd.toCharArray()) {

            // Обязательно есть хоть 1 цифра
            if (ch >='0' && ch <='9')
                has_numeric ++;
            else if (ch >= 'a' && ch<='z') // Должны быть большие и маленькие буквы
                has_small_letters ++;
            else if (ch >= 'A' && ch<='Z')
                has_big_letters++;
            else if (password_special_letters.contains(ch)) // Обязательно дожен быть спец символ
                has_special_letters ++;
        }

        return (has_numeric & has_small_letters & has_big_letters & has_special_letters)>0;
    }

    public static void checkPasswordAndPrint(String pwd) {
        System.out.println("Check if password ["+pwd+"] is good ? " + checkPassword(pwd));
    }

    public static void main(String[] args) {

        checkPasswordAndPrint("ioctl");
        checkPasswordAndPrint("ioctl1");
        checkPasswordAndPrint("iocTl1");
        checkPasswordAndPrint("iocTl1$");
        checkPasswordAndPrint("iocTl1$len");
        checkPasswordAndPrint("iocTl1alen");

    }
}
