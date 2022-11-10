package learning.jsontest.logic;

import org.junit.jupiter.api.Test;

class IMatrixCalculatorImpl1Test {

    @Test
    void getDeterminant() {
        MatrixCalculatorImpl1 impl1 = new MatrixCalculatorImpl1();
        System.out.println(impl1.getDeterminant(new double[][]{{1, -2, 3}, {4, 0, 6}, {-7, 8, 9}}));
        System.out.println(impl1.getDeterminant(new double[][]{{11, -3}, {-15, -2}}));
    }
}