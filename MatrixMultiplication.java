import java.util.Scanner;

public class Multiplication{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row1, col1, row2, col2;
        System.out.println("Enter the order of first matrix(m, n): ");
        row1 = sc.nextInt();
        col1 = sc.nextInt();
        System.out.println("Enter the order of second matrix(m, n): ");
        row2 = sc.nextInt();
        col2 = sc.nextInt();
        int[][] a = new int[row1][col1];
        int[][] b = new int[row2][col2];
        System.out.println("Enter the values of the first matrix: ");
        for(int i = 0; i < a.length; ++i){
            for(int j = 0; j < a[0].length; ++j){
                System.out.print("a" + (i+1) + (j+1) + " value: ");
                int x = sc.nextInt();
                a[i][j] = x;
            }
        }
        System.out.println("Enter the values of the second matrix: ");
        for(int i = 0; i < b.length; ++i){
            for(int j = 0; j < b[0].length; ++j){
                System.out.print("b" + (i+1) + (j+1) + " value: ");
                int x = sc.nextInt();
                b[i][j] = x;
            }
        }

        int[][] product = multiply(a, b);
        System.out.println("The resultant Matrix: ");
        for(int i = 0; i < product.length; ++i){
            for(int j = 0; j < product[0].length; ++j){
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] a, int[][] b){
        int[][] result = new int[a.length][b[0].length];
        for(int i = 0; i < a.length; ++i){
            for(int j = 0; j < b[0].length; ++j){
                result[i][j] = 0;
                for(int k = 0; k < a[0].length; ++k){
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}
