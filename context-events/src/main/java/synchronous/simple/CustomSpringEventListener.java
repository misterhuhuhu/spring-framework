package synchronous.simple;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    @Override
    public void onApplicationEvent(final CustomSpringEvent event) {
        System.out.printf("%s Received spring custom event - %s  in %s \n" ,event.getSource().getClass() , event.getMessage(),Thread.currentThread().getName());
    }

}