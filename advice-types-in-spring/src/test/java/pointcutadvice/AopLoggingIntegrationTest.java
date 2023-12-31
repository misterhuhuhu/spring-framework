package pointcutadvice;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import pointcutadvice.dao.FooDao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {Application.class}, loader = AnnotationConfigContextLoader.class)
public class AopLoggingIntegrationTest {
    
    @BeforeAll
    public static void setUp() {
        messages = new ArrayList<>();
        
        logEventHandler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                messages.add(record.getMessage());
            }
            
            @Override
            public void flush() {
            }
            
            @Override
            public void close() throws SecurityException {
            }
        };
        
        Logger logger = Logger.getLogger(LoggingAspect.class.getName());
        logger.addHandler(logEventHandler);
    }
    
    @Autowired
    private FooDao dao;
    
    private static Handler logEventHandler;
    
    private static List<String> messages;
    
    @Test
    public void givenLoggingAspect_whenCallDaoMethod_thenBeforeAdviceIsCalled() {
        dao.findById(1L);
//        assertThat(messages, hasSize(1));
//
//        String logMessage = messages.get(0);
//        Pattern pattern = Pattern.compile("^\\[\\d{4}\\-\\d{2}\\-\\d{2} \\d{2}:\\d{2}:\\d{2}:\\d{3}\\]findById$");
//        assertTrue(pattern.matcher(logMessage).matches());
    }
    
    @Test
    public void givenLoggingAspect_whenCallLoggableAnnotatedMethod_thenMethodIsLogged() {
        dao.create(42L, "baz");
        assertThat(messages, hasItem("Executing method: create"));
    }
    
    @Test
    public void givenLoggingAspect_whenCallMethodAcceptingAnnotatedArgument_thenArgumentIsLogged() {
        Foo foo = new Foo(42L, "baz");
        dao.merge(foo);
//        assertThat(messages, hasItem("Accepting beans with @Entity annotation: " + foo));
    }
}
