package learning.jsontest.service;

import learning.jsontest.logic.IMatrixCalculator;
import learning.jsontest.service.message.IMessage;
import learning.jsontest.service.message.InputMessage;
import learning.jsontest.service.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/service")
public class MatrixCalculatorService {
    @Autowired
    Environment environment;
    @Autowired
    IMatrixCalculator calculator;

    @GetMapping("/ping")
    public Message ping() {
        return new Message("pong");
    }

    @GetMapping("/status")
    public Message status() throws UnknownHostException {
        return new Message("Server running at " + InetAddress.getLocalHost().getHostAddress() + ":" +
                environment.getProperty("local.server.port"));
    }

    @PostMapping("/solve")
    public IMessage solve(@RequestBody InputMessage input) {
        return calculator.solve(input);
    }
}