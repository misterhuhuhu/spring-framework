package aspectj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class PersonObject {
    @Autowired
    private IdService idService;

    private int id;
    private String name;

    public PersonObject(String name) {
        this.name = name;
    }

    void generateId() {
        this.id = idService.generateId();
    }
    
    public IdService getIdService() {
        return idService;
    }
    
    public void setIdService(IdService idService) {
        this.idService = idService;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}