package applicationcontext;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    
    @Resource
    private ApplicationContext applicationContext;
    
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
}
