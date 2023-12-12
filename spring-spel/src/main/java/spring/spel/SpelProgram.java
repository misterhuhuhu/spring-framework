package spring.spel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import spring.spel.examples.SpelConditional;


@SpringBootApplication
public class SpelProgram {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpelProgram.class);
        SpelConditional spelCollections = (SpelConditional) context.getBean("spelConditional");
        
        // Here you can choose which bean do you want to load instead of spelConditional: spelCollections, spelLogical, etc.
        
        System.out.println(spelCollections);
    }
    
}
