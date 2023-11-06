package synchronous;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.springframework.util.Assert.isTrue;

@SpringBootTest
@ContextConfiguration(classes = {SynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
public class ContextRefreshedListenerIntegrationTest {
    
    @Resource
    private ContextRefreshedListener listener;
    
    @Test
    public void testContextRefreshedListener() {
        System.out.println("Test context re-freshed listener.");
        isTrue(listener.isHitContextRefreshedHandler(), "Refresh should be called once");
    }
}