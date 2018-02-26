package AlertEventLog.util;

import AlertEventLog.entity.AlertLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean(name="testDemo")
    public AlertLog generateDemo() {
        AlertLog demo = new AlertLog();
        demo.setId(12345);
        demo.setThread("test");
        return demo;
    }
}
