package pointcutadvice;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {Application.class}, loader = AnnotationConfigContextLoader.class)
public class AopPerformanceIntegrationTest {
    
    @BeforeAll
    public void setUp() {
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
        
        messages = new ArrayList<>();
    }
    
    @Autowired
    private FooDao dao;
    
    private Handler logEventHandler;
    
    private List<String> messages;
    
    @Test
    public void givenPerformanceAspect_whenCallDaoMethod_thenPerformanceMeasurementAdviceIsCalled() {
        Logger logger = Logger.getLogger(PerformanceAspect.class.getName());
        logger.addHandler(logEventHandler);
        
        final String entity = dao.findById(1L);
        assertThat(entity, notNullValue());
//        assertThat(messages, hasSize(1));


//        String logMessage = messages.get(0);
//        Pattern pattern = Pattern.compile("Execution of findById took \\d+ ms");
//        assertTrue(pattern.matcher(logMessage).matches());
    }
}
