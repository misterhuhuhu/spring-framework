package listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ContextEventListener {

    @Order(2)
    @EventListener
    public void handleContextStartedEvent(ContextStartedEvent ctxStartEvt) {
        System.out.println("ContextStartedEvent received.");
    }

    @Order(1)
    @EventListener(classes = { ContextStartedEvent.class, ContextStoppedEvent.class })
    public void handleMultipleEvents() {
        System.out.println("Multi-event listener invoked");
    }
    @Order(3)
    @EventListener
    public void handleContextStoppedEvent(ContextStoppedEvent contextStoppedEvent){
        System.out.println("ContextStoppedEvent received");
    }
    @Order(4)
    @EventListener
    public void handleContextClosedEvent(ContextClosedEvent contextClosedEvent){
        System.out.println("ContextClosedEvent received");
    }

}
