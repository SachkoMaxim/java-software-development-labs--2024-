package com.sachkomaxim.lab1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int[][] EXAMPLE_A = {
                {1, 48, 3, 18},
                {6, 55, 6, 22},
                {27, 8, 49, 8}
        };

        final int[][] EXAMPLE_B = {
                {9, 8, 7, 16},
                {6, 70, 17, 1},
                {3, 5, 41, 22}
        };

        int[][] A;
        int[][] B;

        try {
            System.out.println("Рядки та стовпці для матриці A (спочатку рядки вводяться, потім стопці):");
            A = getRandomMatrixFromInput();

            System.out.println("\nРядки та стовпці для матриці B (спочатку рядки вводяться, потім стопці):");
            B = getRandomMatrixFromInput();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Виникла проблема під час отримання рядків і стовпців із консолі: " + e.getLocalizedMessage());
        }

//      A = EXAMPLE_A;
//      B = EXAMPLE_B;

        int[][] C;

        System.out.println("\nМатриця A:");
        printMatrix(A);

        System.out.println("Матриця B:");
        printMatrix(B);

        try {
            C = xorMatrices(A, B);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Під час процесу побітового виключного “але” (XOR) матриць було виявлено виняток:\n" + e.getLocalizedMessage());
        }
        System.out.println("Матриця C = A XOR B:");
        printMatrix(C);

        try {
            double[] rowAverages = calculateRowAverages(C);
            System.out.println("Середнє значення кожного рядка матриці C:");
            printArray(rowAverages);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Під час обчислення середніх значень рядків виявлено виняток:\n" + e.getLocalizedMessage());
        }
    }

    public static int[][] getRandomMatrixFromInput() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        int[] params = new int[2];
        for (int i = 0; i < 2; i++) {
            if (!scanner.hasNextInt()) {
                scanner.close();
                throw new IllegalArgumentException("Була спроба передати значення нечислового типу.");
            }
            int newParam = scanner.nextInt();
            if (newParam <= 0) {
                scanner.close();
                throw new IllegalArgumentException("Була спроба передати недодатне значення.");
            }
            params[i] = newParam;
        }
        return generateRandomMatrix(params[0], params[1]);
    }

    public static int[][] generateRandomMatrix(int numRows, int numCols) {
        int[][] matrix = new int[numRows][numCols];
        Random random = new Random();
        int valueRange = 50;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = random.nextInt(valueRange);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    private static int[][] xorMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException(String.format("Розміри матриць A та B не співпадають: A[%d][%d], A[%d][%d]",
                    a.length, a[0].length, b.length, b[0].length));
        }

        int rows = a.length;
        int cols = a[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = a[i][j] ^ b[i][j]; // XOR
            }
        }
        return resultMatrix;
    }

    private static double[] calculateRowAverages(int[][] matrix) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Матриця, для якої ви намагаєтесь отримати середні значення рядка, порожня.");
        }
        int rows = matrix.length;
        double[] averages = new double[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            averages[i] = (double) sum / matrix[i].length;
        }
        return averages;
    }

    private static void printArray(double[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("}");
    }
}
