import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            int[][] matrix1 = readMatrix(args[0]);
            int[][] matrix2 = readMatrix(args[1]);
            System.out.println("Matrix 1:");
            printMatrix(matrix1);
            System.out.println("Matrix 2:");
            printMatrix(matrix2);
            int[][] result = Matrixmultiply(matrix1, matrix2);
            System.out.println("matrix 3:");
            printMatrix(result);
            writeMatrixToFile(result, "matrix3.txt");
        } else if (args.length == 1) {
            int size = Integer.parseInt(args[0]);
            int[][] matrix1 = generateRandomMatrix(size);
            int[][] matrix2 = generateRandomMatrix(size);
            writeMatrixToFile(matrix1, "data/matrix1.txt");
            writeMatrixToFile(matrix2, "data/matrix2.txt");
            System.out.println("Matrix 1:");
            printMatrix(matrix1);
            System.out.println("Matrix 2:");
            printMatrix(matrix2);
            int[][] result = Matrixmultiply(matrix1, matrix2);
            System.out.println("matrix 3:");
            printMatrix(result);
            writeMatrixToFile(result, "matrix3.txt");
        } else {
            System.out.println("Please enter a valid input");
        }

    }

    public static int[][] generateRandomMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public static void writeMatrixToFile(int[][] matrix, String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int[] row : matrix) {
                for (int num : row) {
                    bw.write(num + " ");
                }
                bw.newLine();
            }
        }
    }

    public static int[][] Matrixmultiply(int[][] matrix1, int[][] matrix2) {
        int m1Rows = matrix1.length;
        int m1Cols = matrix1[0].length;
        int m2Cols = matrix2[0].length;

        int[][] result = new int[m1Rows][m2Cols];

        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m1Cols; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] readMatrix(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        int rows = lines.size();
        int cols = lines.get(0).split(" ").length;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] nums = lines.get(i).split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
