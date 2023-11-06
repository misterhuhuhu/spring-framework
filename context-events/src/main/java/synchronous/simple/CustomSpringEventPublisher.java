package synchronous.simple;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import synchronous.generic.GenericSpringAppEvent;
import synchronous.generic.GenericSpringEvent;
import synchronous.generic.GenericStringSpringAppEvent;
import synchronous.generic.GenericStringSpringEvent;

@Component
public class CustomSpringEventPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.printf("Publishing custom event in %s\n",Thread.currentThread().getName());
        final CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
    

}
