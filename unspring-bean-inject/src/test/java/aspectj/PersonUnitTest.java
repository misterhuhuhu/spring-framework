package aspectj;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AspectJConfig.class)
public class PersonUnitTest {

    @Test
    public void givenUnmanagedObjects_whenInjectingIdService_thenIdValueIsCorrectlySet() {
        PersonObject personObject = new PersonObject("Baeldung");
        personObject.generateId();
        IdService idService = personObject.getIdService();
        assertEquals(1, personObject.getId());
        assertEquals("Baeldung", personObject.getName());

        PersonEntity personEntity = new PersonEntity("Baeldung");
        assertEquals(2, personEntity.getId());
        assertEquals("Baeldung", personEntity.getName());
    }
}