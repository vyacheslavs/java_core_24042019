package Lesson_2.Exceptions;

public class Main {

    public static void case_1() {
        try {

            System.out.println("========================================================== String[5][4] ==========================================================");

            String [][] ar = new String[5][4];
            PlayWithArrays.checkDimensions(ar);
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
    }

    public static void case_2() {
        try {
            System.out.println("\n========================================================== String[4][5] ==========================================================");

            String [][] ar = new String[4][3];
            PlayWithArrays.checkDimensions(ar);
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
    }

    public static void case_3() {
        try {
            System.out.println("\n========================================================== String[4][4] ==========================================================");

            String [][] ar = new String[4][4];
            PlayWithArrays.checkDimensions(ar);
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
    }

    public static void case_4() {
        try {

            System.out.println("\n========================================================== retVal = 40 ==========================================================");

            String [][] ar = new String[4][4];

            ar[0][0] = "1";
            ar[0][1] = "2";
            ar[0][2] = "3";
            ar[0][3] = "4";

            ar[1][0] = "1";
            ar[1][1] = "2";
            ar[1][2] = "3";
            ar[1][3] = "4";

            ar[2][0] = "1";
            ar[2][1] = "2";
            ar[2][2] = "3";
            ar[2][3] = "4";

            ar[3][0] = "1";
            ar[3][1] = "2";
            ar[3][2] = "3";
            ar[3][3] = "4";

            PlayWithArrays.checkDimensions(ar);
            System.out.println("Sum of array: "+PlayWithArrays.sumArray(ar));
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
    }

    public static void case_5() {
        try {

            System.out.println("\n========================================================== exception at 0,3 ==========================================================");

            String [][] ar = new String[4][4];

            ar[0][0] = "1";
            ar[0][1] = "2";
            ar[0][2] = "3";
            ar[0][3] = "a";

            ar[1][0] = "1";
            ar[1][1] = "2";
            ar[1][2] = "3";
            ar[1][3] = "4";

            ar[2][0] = "1";
            ar[2][1] = "2";
            ar[2][2] = "3";
            ar[2][3] = "4";

            ar[3][0] = "1";
            ar[3][1] = "2";
            ar[3][2] = "3";
            ar[3][3] = "4";

            PlayWithArrays.checkDimensions(ar);
            System.out.println("Sum of array: "+PlayWithArrays.sumArray(ar));
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        case_1();
        case_2();
        case_3();
        case_4();
        case_5();

    }

}
