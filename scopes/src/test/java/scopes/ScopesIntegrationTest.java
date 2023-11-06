package scopes;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopesIntegrationTest {
    
    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";
    
    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("scopes");
        
        final Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        final Person personSingletonB = (Person) applicationContext.getBean("personSingleton");
        
        personSingletonA.setName(NAME);
        Assertions.assertEquals(personSingletonB, personSingletonA);
        
        applicationContext.close();
    }
    
    @Test
    public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("scopes");
        
        final Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
        final Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");
        
        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);
        
        
        Assertions.assertEquals(NAME, personPrototypeA.getName());
        Assertions.assertEquals(NAME_OTHER, personPrototypeB.getName());
        
        applicationContext.close();
    }
    
}
