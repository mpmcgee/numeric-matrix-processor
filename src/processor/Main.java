package processor;
import java.util.Scanner;

public class Main {


    public static int[][] createMatrix(){
        Scanner scanner = new Scanner(System.in);
        String dims = scanner.nextLine();
        String[] arrDims = dims.split(" ");
        int numRows = Integer.parseInt(arrDims[0]);
        int numCols = Integer.parseInt(arrDims[1]);

        int[][] matrix = new int[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;

    }

    public static void addMatrices(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length) {
            int[][] sumMatrix = new int[matrixA.length][matrixA[0].length];

            for (int row = 0; row < sumMatrix.length; row++) {
                for (int col = 0; col < sumMatrix[0].length; col++) {
                    sumMatrix[row][col] = matrixA[row][col] + matrixB[row][col];

                    if (col == 0) {
                        System.out.print("\n");
                    }

                    System.out.print(sumMatrix[row][col] + " ");
                }
            }


        } else {
            System.out.println("ERROR");
        }
    }

    public static void multiplyMatrixByConstant() {
        int[][] matrix = createMatrix();

        Scanner scanner = new Scanner(System.in);
        int cons = scanner.nextInt();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = matrix[row][col] * cons;

                if (col == 0) {
                    System.out.print("\n");
                }

                System.out.print(matrix[row][col] + " ");
            }
        }

    }

    public static void main(String[] args) {

        // int[][] matrixA = createMatrix();
        // int[][] matrixB = createMatrix();

        // addMatrices(matrixA, matrixB);

        multiplyMatrixByConstant();
    }
}
