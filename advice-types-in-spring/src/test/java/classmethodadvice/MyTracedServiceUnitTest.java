package classmethodadvice;


import org.junit.jupiter.api.Test;


/*
 * When running this test class, the tests may fail unless you build the
 * code with Maven first. You
 * must ensure the AspectJ compiler executes to weave in the Aspect's logic.
 * Without the Aspect
 * weaved into the class under test, the trace logging will not be written to stdout.
 */
public class MyTracedServiceUnitTest {
    
    
    @Test
    public void whenPerformingSomeLogic_thenTraceAndInfoOutputIsWritten() {
        MyTracedService myTracedService = new MyTracedService();
        myTracedService.performSomeLogic();
        
        
    }
    
    @Test
    public void whenPerformingSomeAdditionalLogic_thenTraceAndInfoOutputIsWritten() {
        MyTracedService myTracedService = new MyTracedService();
        myTracedService.performSomeAdditionalLogic();
        
        
    }
}