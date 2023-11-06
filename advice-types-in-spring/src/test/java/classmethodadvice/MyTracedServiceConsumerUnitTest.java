package classmethodadvice;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@SpringBootTest
@EnableAspectJAutoProxy
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,classes = ConfigClass.class)
public class MyTracedServiceConsumerUnitTest {


    @Resource
    private MyTracedService myTracedService;

    @Test
    public void whenCallingConsumer_thenServiceIsCalled() {
        myTracedService.performSomeLogic();
//        myTracedService.performSomeAdditionalLogic();

    }
}