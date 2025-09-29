import java.io.File;
import java.util.Scanner;

public class Satellite {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input3.txt"));
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] img1 = readImage(sc, n, m);
        int[][] img2 = readImage(sc, n, m);
        int[] box = computeBoundingBox(img1, img2);
        if (box[2] == -1) System.out.println("IDENTICAL");
        else System.out.println(box[0] + " " + box[1] + " " + box[2] + " " + box[3]);
    }

    static int[][] readImage(Scanner sc, int rows, int cols) {
        int[][] img = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                img[i][j] = sc.nextInt();
        return img;
    }

    static int[] computeBoundingBox(int[][] a, int[][] b) {
        int y1 = a.length, x1 = a[0].length, y2 = -1, x2 = -1;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] != b[i][j]) {
                    y1 = Math.min(y1, i); y2 = Math.max(y2, i);
                    x1 = Math.min(x1, j); x2 = Math.max(x2, j);
                }
        return new int[]{y1, x1, y2, x2};
    }
}
