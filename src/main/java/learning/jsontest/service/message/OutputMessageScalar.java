package learning.jsontest.service.message;

public class OutputMessageScalar implements IMessage {
    public Double determinant;

    public OutputMessageScalar(double determinant) {
        this.determinant = determinant;
    }

    @Override
    public String toString() {
        return determinant.toString();
    }
}
