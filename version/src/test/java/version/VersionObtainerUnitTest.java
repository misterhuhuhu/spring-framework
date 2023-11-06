package version;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = VersionObtainer.class)
public class VersionObtainerUnitTest {
    
    @Resource
    public VersionObtainer version;
    
    @Test
    public void testVersion() {
        System.err.println(version.getSpringVersion());
        System.err.println(version.getJdkVersion());
        System.err.println(version.getJavaVersion());
    }
    
    
}
