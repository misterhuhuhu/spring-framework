package countingbeans.latestsspring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnnotatedBeansIntegrationTest {
    
    @Test
    void whenApplicationContextStarted_ThenShouldDetectAllAnnotatedBeans() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext( MyComponent.class, MyConfigurationBean.class )) {
            Map<String,Object> beans = applicationContext.getBeansWithAnnotation(MyCustomAnnotation.class);
            assertEquals(2, beans.size());
            assertTrue(beans.keySet().containsAll(Arrays.asList("myComponent", "myService")));
        }
    }

}