package methodinjections;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("studentBean")
public abstract class Student {

    private String id;

    /**
     * Injects a prototype bean SchoolNotification into Singleton student
     */
    @Lookup
    public abstract SchoolNotification getNotification(String name) ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
