package org.example;

import java.util.Scanner;

public class MatrixApp {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Створити матрицю вручну (1) чи рандомно (2)? Виберіть 1 або 2: ");
        int choice = scanner.nextInt();

        int[][] matrix;
        if (choice == 1) {
            int rows = promptMatrixSize(scanner, "Введіть висоту матриці (не більше 20): ");
            int cols = promptMatrixSize(scanner, "Введіть ширину матриці (не більше 20): ");
            matrix = MatrixCalculator.createMatrixManual(scanner, rows, cols);
        } else {

            int DEFAULT_ROWS = 5;
            int DEFAULT_COLS = 5;

            matrix = MatrixCalculator.createMatrixRandom(DEFAULT_ROWS, DEFAULT_COLS);
            System.out.printf("Було створено рандомну матрицю розміром %dx%d\n", DEFAULT_ROWS, DEFAULT_COLS);
        }

        System.out.println("\nМатриця:");
        MatrixCalculator.printMatrix(matrix);

        printResults(matrix);

        scanner.close();
    }

    private int promptMatrixSize(Scanner scanner, String message) {
        System.out.print(message);
        return MatrixCalculator.readValidSize(scanner);
    }

    private void printResults(int[][] matrix) {
        int min = MatrixCalculator.findMin(matrix);
        int max = MatrixCalculator.findMax(matrix);
        double average = MatrixCalculator.calculateAverage(matrix);
        Double geometricMean = MatrixCalculator.calculateGeometricMean(matrix);

        System.out.println("\nМінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.printf("Середнє арифметичне: %.2f%n", average);

        if (geometricMean != null) {
            System.out.printf("Середнє геометричне (для додатних): %.2f%n", geometricMean);
        } else {
            System.out.println("Середнє геометричне не може бути обчислене (немає додатних чисел).");
        }
    }
}
