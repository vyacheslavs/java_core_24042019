package Lesson_2.Exceptions;

public class MyArrayException extends RuntimeException {
    MyArrayException(String msg, Throwable cause) {
        super(msg, cause);
    }

    MyArrayException(Throwable cause) {
        super(cause);
    }
}
