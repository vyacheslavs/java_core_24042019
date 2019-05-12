package Lesson_2.Exceptions;

public class PlayWithArrays {

    final static int checkDimensionSize = 4;

    public static void checkDimensions(String[][] ar) throws MyArrayException {
        if ( ar.length != checkDimensionSize )
            throw new MyArrayException(new MyArraySizeException(ar.length));

        for (int i=0;i<ar.length;++i) {
            if (ar[i].length != checkDimensionSize)
                throw new MyArrayException(new MyArraySizeException(ar[i].length));
        }
    }

    public static int sumArray(String[][] ar) throws MyArrayException {
        int i=0,j=0;
        try {
            int retVal = 0;
            for (;i<ar.length;++i) {
                for (j=0;j<ar[i].length; ++j) {
                    retVal += Integer.parseInt(ar[i][j]);
                }
            }
            return retVal;
        } catch (NumberFormatException e) {
            throw new MyArrayException(new MyArrayDataException(i,j,e));
        }
    }
}
