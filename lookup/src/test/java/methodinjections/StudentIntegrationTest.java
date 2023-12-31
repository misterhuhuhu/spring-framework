package methodinjections;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentIntegrationTest {

    private ConfigurableApplicationContext context;

    @AfterEach
    public void tearDown() {
        context.close();
    }

    @Test
    public void whenLookupMethodCalled_thenNewInstanceReturned() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student1 = context.getBean("studentBean", Student.class);
        Student student2 = context.getBean("studentBean", Student.class);

        assertEquals(student1, student2);
        System.out.println(student1.getNotification("Alex").getName());
        System.out.println(student2.getNotification("Bethany").getName());
//        assertNotEquals(student1.getNotification("Alex"), student2.getNotification("Bethany"));
    }

    @Test
    public void whenAbstractGetterMethodInjects_thenNewInstanceReturned() {
        context = new ClassPathXmlApplicationContext("beans.xml");

        StudentServices services = context.getBean("studentServices", StudentServices.class);

        assertEquals("PASS", services.appendMark("Alex", 76));
        assertEquals("FAIL", services.appendMark("Bethany", 44));
        assertEquals("PASS", services.appendMark("Claire", 96));
    }
}
