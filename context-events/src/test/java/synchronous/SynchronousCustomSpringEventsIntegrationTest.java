package synchronous;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import synchronous.generic.GenericSpringEventPublisher;
import synchronous.simple.CustomSpringEventPublisher;

import static org.springframework.util.Assert.isTrue;

@SpringBootTest
@ContextConfiguration(classes = {SynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SynchronousCustomSpringEventsIntegrationTest {
    
    @Autowired
    private CustomSpringEventPublisher customSpringEventPublisher;
    @Autowired
    private GenericSpringEventPublisher genericSpringEventPublisher;
    @Autowired
    private AnnotationDrivenEventListener listener;
    
    @Test
    public void testCustomSpringEvents() {
        isTrue(!listener.isHitCustomEventHandler(), "The value should be false");
        customSpringEventPublisher.publishCustomEvent("Hello world!!");
        System.out.println("Done publishing synchronous custom event. ");
        isTrue(listener.isHitCustomEventHandler(), "Now the value should be changed to true");
    }
    
    @Test
    public void testGenericSpringEvent() {
        isTrue(!listener.isHitSuccessfulEventHandler(), "The initial value should be false");
        genericSpringEventPublisher.publishGenericEvent("Hello world!!!", true);
        isTrue(listener.isHitSuccessfulEventHandler(), "Now the value should be changed to true");
    }
    
    @Test
    public void testGenericSpringEventNotProcessed() {
        isTrue(!listener.isHitSuccessfulEventHandler(), "The initial value should be false");
        genericSpringEventPublisher.publishGenericEvent("Hello world!!!", false);
        isTrue(!listener.isHitSuccessfulEventHandler(), "The value should still be false");
    }
    
    @Test
    public void testContextStartedEvent() {
        isTrue(listener.isHitContextStartedHandler(), "Start should be called once");
    }
}
