import java.util.Scanner;

public class MatrixAdjoint {

    public static int det(int[] ar){
        return (ar[0]*ar[3] - ar[1]*ar[2]);
    }

    public static boolean isOddOrEven(int num){
        return num % 2 == 0;
    }

    public static int[][] transpose(int[][] matrix){
        int[][] transposeMatrix = new int[3][3];
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                transposeMatrix[i][j] = matrix[j][i];
            }
        }
        return transposeMatrix;
    }

    public static int[][] cofactorMatrix(int[][] matrix){
        int[][] cofactMatrix = new int[3][3];
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                int track = 0;
                int[] ar = new int[4];
                for(int k = 0; k < 3; ++k){
                    for(int l = 0; l < 3; ++l){
                        if(!(k == i || l == j)){
                            ar[track] = matrix[k][l];
                            if(!(ar.length == 3))
                                track++;
                        }
                    }
                }
                int multiple = isOddOrEven(i+j) ? 1 : -1;
                cofactMatrix[i][j] = multiple*det(ar);
            }
        }

        return cofactMatrix;
    }

    public static void displayMatrix(int[][] matrix){
        for(int[] ar : matrix){
            for(int value : ar){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                System.out.println("Enter the matrix(A) element["+(i+1)+"]["+(j+1)+"]:");
                matrix[i][j] = inp.nextInt();
            }
        }

        System.out.println("The created matrix A is: ");

        displayMatrix(matrix);

        System.out.println("The resultant matrix (adj A) is: ");
        int[][] resultantMatrix = transpose(cofactorMatrix(matrix));

        displayMatrix(resultantMatrix);


    }
}
