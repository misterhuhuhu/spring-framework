package factorybean;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FactoryBeanAppConfig.class)
public class FactoryBeanJavaConfigIntegrationTest {


    @Resource(name = "&toolFactory")
    private ToolFactory toolFactory;

    @Resource
    private ApplicationContext applicationContext;
    @Test
    public void testConstructWorkerByJava() {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
            System.out.println(applicationContext.getType(beanDefinitionName));
        }
    }
}