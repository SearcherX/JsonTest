package learning.jsontest.service.message;

import java.util.Date;

public class Message implements IMessage {
    public String message;
    public Date time;

    public Message(String message) {
        this.message = message;
        time = new Date();
    }

    @Override
    public String toString() {
        return "ClassMessage{" +
                "message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
