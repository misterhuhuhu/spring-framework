package synchronous;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import synchronous.generic.GenericSpringEventListener;
import synchronous.generic.GenericSpringEventPublisher;

import static org.springframework.util.Assert.isTrue;

@SpringBootTest
@ContextConfiguration(classes = {SynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
public class GenericAppEventListenerIntegrationTest {
    
    @Autowired
    private GenericSpringEventPublisher publisher;
    @Autowired
    private GenericSpringEventListener listener;
    
    @Test
    public void testGenericSpringEvent() {
        isTrue(!listener.isHitEventHandler(), "The initial value should be false");
        publisher.publishGenericAppEvent("Hello world!!!");
        isTrue(listener.isHitEventHandler(), "Now the value should be changed to true");
    }
    
}