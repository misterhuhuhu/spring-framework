package synchronous.generic;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import synchronous.simple.CustomSpringEvent;

@Component
public class GenericSpringEventPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    
    public void publishGenericEvent(final String message, boolean success) {
        System.out.println("Publishing generic event.");
        final GenericSpringEvent<String> genericSpringEvent = new GenericStringSpringEvent(message, success);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

    public void publishGenericAppEvent(final String message) {
        System.out.println("Publishing generic event.");
        final GenericSpringAppEvent<String> genericSpringEvent = new GenericStringSpringAppEvent(this, message);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

}
