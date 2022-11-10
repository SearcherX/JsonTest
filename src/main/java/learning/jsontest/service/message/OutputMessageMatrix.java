package learning.jsontest.service.message;

import java.util.Arrays;

public class OutputMessageMatrix implements IMessage {
    public double[][] matrix;

    public OutputMessageMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
