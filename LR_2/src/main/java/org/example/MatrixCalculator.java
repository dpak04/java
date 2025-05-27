package org.example;

import java.util.Random;
import java.util.Scanner;

public class MatrixCalculator {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = -100;
    private static final int RANDOM_MAX = 100;

    public static int readValidSize(Scanner scanner) {
        int size;
        do {
            size = scanner.nextInt();
            if (size <= 0 || size > MAX_SIZE) {
                System.out.print("Невірне значення. Введіть число від 1 до 20: ");
            }
        } while (size <= 0 || size > MAX_SIZE);
        return size;
    }

    public static int[][] createMatrixManual(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Елемент [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] createMatrixRandom(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = RANDOM_MIN + random.nextInt(RANDOM_MAX - RANDOM_MIN + 1);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
    }

    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < min) {
                    min = val;
                }
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }

    public static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
                count++;
            }
        }
        return (double) sum / count;
    }

    public static Double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val > 0) {
                    product *= val;
                    count++;
                }
            }
        }

        if (count == 0) return null;

        return Math.pow(product, 1.0 / count);
    }

}
