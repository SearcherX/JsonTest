package learning.jsontest.service.message;

public class InputMessage implements IMessage {
    public double[][] firstMatrix;
    public double[][] secondMatrix;
    public String operation;

    public InputMessage(double[][] firstMatrix, double[][] secondMatrix, String operation) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.operation = operation;
    }
}