package Practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        try {
            Programmer programmer = (Programmer) context.getBean(args[0].toLowerCase());
            programmer.doCoding();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
