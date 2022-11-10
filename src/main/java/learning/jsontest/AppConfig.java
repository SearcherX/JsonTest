package learning.jsontest;

import learning.jsontest.logic.IMatrixCalculator;
import learning.jsontest.logic.MatrixCalculatorImpl1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    IMatrixCalculator matrixCalculator() {
        return new MatrixCalculatorImpl1();
    }
}
