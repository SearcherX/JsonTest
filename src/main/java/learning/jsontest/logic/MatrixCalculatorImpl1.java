package learning.jsontest.logic;

import learning.jsontest.service.message.*;

public class MatrixCalculatorImpl1 implements IMatrixCalculator {
    @Override
    public IMessage solve(InputMessage input) {
        double[][] matrix1 = input.firstMatrix;
        double[][] matrix2 = input.secondMatrix;
        String operation = input.operation;

        IMessage out = null;
        try {
            switch (operation) {
                case "add" -> out = new OutputMessageMatrix(addition(matrix1, matrix2));
                case "sub" -> out = new OutputMessageMatrix(subtraction(matrix1, matrix2));
                case "multi" -> out = new OutputMessageMatrix(multiplication(matrix1, matrix2));
                case "det" -> out = new OutputMessageScalar(getDeterminant(matrix1));
            }
        } catch (Exception e) {
            out = new ErrorMessage(e.getMessage());
        }
        return out;
    }

    public double[][] addition(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length)
            throw new IllegalArgumentException("Разная размерность матриц");

        double[][] res = new double[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                res[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return res;
    }

    public double[][] subtraction(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length)
            throw new IllegalArgumentException("Разная размерность матриц");

        double[][] res = new double[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                res[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return res;
    }

    //метод умножения матриц
    public double[][] multiplication(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length)
            throw new IllegalArgumentException("Размерности матриц должны быть m * n и n * k");

        double[][] res = new double[matrix1.length][matrix2[0].length];

        //перебор столбцов 1-ой мтарицы
        for (int i = 0; i < matrix1.length; i++) {
            //перебор строк 2-ой матрицы
            for (int j = 0; j < matrix2[i].length; j++) {
                int sum = 0;
                //перебор строк 1-ой матрицы+перебор столбцов 2-ой матрицы
                for (int k = 0; k < matrix1[i].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                //запись в результирующую матрицы
                res[i][j] = sum;
            }

        }
        return res;
    }

    //метод нахождения определителя
    public double getDeterminant(double[][] matrix) {
        Determin dd = new Determin(matrix);
        return dd.getValue();
    }
}
