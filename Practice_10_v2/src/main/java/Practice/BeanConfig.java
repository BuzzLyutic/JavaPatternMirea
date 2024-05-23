package Practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("junior")
    public Programmer Junior(){
        return new Junior();
    }
    @Bean("middle")
    public Programmer Middle(){
        return new Middle();
    }
    @Bean("senior")
    public Programmer Senior(){
        return new Senior();
    }
}
