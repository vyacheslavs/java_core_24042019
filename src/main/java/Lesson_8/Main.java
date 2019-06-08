package Lesson_8;

public class Main {

    public static void main(String[] args) {

        final int w = 9;
        final int h = 9;
        int [][] arr = new int[w][h];

        int i = 0, j, k=0, p=1;

        while (i<w*h) {
            k++;
            for (j=k-1;j<h-k+1;j++,i++) {
                arr[k-1][j] = p++;
            }
            for (j=k;j<w-k+1;j++,i++) {
                arr[j][h-k] = p++;
            }
            for (j=h-k-1;j>=k-1;j--,i++) {
                arr[w-k][j] = p++;
            }
            for (j=w-k-1;j>=k;j--,i++) {
                arr[j][k-1] = p++;
            }
        }

        for (i=0;i<w;++i) {
            for (j=0;j<h;++j) {
                System.out.print(String.format("%02d", arr[i][j])+" ");
            }
            System.out.println("");
        }
    }
}
