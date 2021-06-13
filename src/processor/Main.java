package processor;
import java.util.Scanner;

public class Main {


    public static double[][] createMatrix(){
        Scanner scanner = new Scanner(System.in);
        String dims = scanner.nextLine();
        String[] arrDims = dims.split(" ");
        int numRows = Integer.parseInt(arrDims[0]);
        int numCols = Integer.parseInt(arrDims[1]);

        double[][] matrix = new double[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = scanner.nextDouble();
            }
        }

        return matrix;

    }

    public static void addMatrices() {

        double[][] matrixA = createMatrix();
        double[][] matrixB = createMatrix();

        if (matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length) {
            double[][] sumMatrix = new double[matrixA.length][matrixA[0].length];

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
        double[][] matrix = createMatrix();

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

    public static double multiplyMatrixCells(double[][] matrixA, double[][] matrixB, int row, int col) {
        double cell = 0;

        for (int i = 0; i < matrixB.length; i++) {
            cell += matrixA[row][i] * matrixB[i][col];
        }

        return cell;
    }

    public static void multiplyMatrices() {
        double[][] matrixA = createMatrix();
        double[][] matrixB = createMatrix();
        double[][] productMatrix = new double[matrixA.length][matrixB[0].length];
        double product = 0;

        if (matrixA[0].length == matrixB.length) {
            for (int row = 0; row < productMatrix.length; row++) {
                for (int col = 0; col < productMatrix[0].length; col++) {
                    productMatrix[row][col] = multiplyMatrixCells(matrixA, matrixB, row, col);
                }
            }

            for (int row = 0; row < productMatrix.length; row++) {
                for (int col = 0; col < productMatrix[0].length; col++) {

                    if (col == 0) {
                        System.out.print("\n");
                    }

                    System.out.print(productMatrix[row][col] + " ");
                }
            }
        } else {
            System.out.println("ERROR");
        }
    }

    public static void printMenu() {
        System.out.println("\n");
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "0. Exit\n" +
                "Your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // addMatrices(matrixA, matrixB);

        // multiplyMatrixByConstant();

        int selection = 6;

        while (selection != 0) {
            printMenu();
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyMatrixByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}
