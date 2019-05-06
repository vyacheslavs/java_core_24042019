package Lesson_2.Exceptions;

public class MyArraySizeException extends RuntimeException {

    MyArraySizeException(int dim) {
        super("Wrong 2d array dimensions: expecting "+String.valueOf(PlayWithArrays.checkDimensionSize)+", got "+String.valueOf(dim));
    }

}
