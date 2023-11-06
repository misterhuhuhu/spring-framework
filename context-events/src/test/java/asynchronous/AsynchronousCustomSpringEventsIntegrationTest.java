package asynchronous;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import synchronous.simple.CustomSpringEventPublisher;

@SpringBootTest
@ContextConfiguration(classes = {AsynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
public class AsynchronousCustomSpringEventsIntegrationTest {
    
    @Resource
    private CustomSpringEventPublisher publisher;
    @Resource
    private ApplicationContext ctx;
    @Test
    public void testCustomSpringEvents() throws InterruptedException {
        
        publisher.publishCustomEvent("Hello world!!");
        System.out.printf("Done publishing asynchronous custom event in %s\n",Thread.currentThread().getName());
    }
}
