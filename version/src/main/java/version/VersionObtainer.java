package version;


import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.system.SystemProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;

@Configuration
public class VersionObtainer {

    public String getSpringVersion() {
        return SpringVersion.getVersion();
    }
    
    public String getJavaVersion() {
        return JavaVersion.getJavaVersion().toString();
    }
    
    public String getJdkVersion() {
        return SystemProperties.get("java.version");
    }
}
