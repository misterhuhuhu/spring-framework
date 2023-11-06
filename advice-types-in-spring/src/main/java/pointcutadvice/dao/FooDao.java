package pointcutadvice.dao;


import org.springframework.stereotype.Repository;
import pointcutadvice.Foo;
import pointcutadvice.annotations.Loggable;

@Repository
public class FooDao {

    public String findById(Long id) {
        return "Bazz";
    }

    @Loggable
    public Foo create(Long id, String name) {
        return new Foo(id, name);
    }

    public Foo merge(Foo foo) {
        return foo;
    }
}
