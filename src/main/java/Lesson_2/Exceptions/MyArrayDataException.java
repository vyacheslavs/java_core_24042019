package Lesson_2.Exceptions;

public class MyArrayDataException extends RuntimeException {
    MyArrayDataException(int i, int j, Throwable cause) {
        super("Wrong array format at ["+String.valueOf(i)+", "+String.valueOf(j)+"] cell", cause);
        cell_i = i;
        cell_j = j;
    }

    public int getCell_i() {
        return cell_i;
    }

    public int getCell_j() {
        return cell_j;
    }

    private int cell_i;
    private int cell_j;
}
