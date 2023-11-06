package classpathfileaccess;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test class illustrating various methods of accessing a file from the classpath using Resource.
 *
 * @author tritty
 */

@SpringBootTest
@SpringBootConfiguration
public class SpringResourceIntegrationTest {
    /**
     * Resource loader instance for lazily loading resources.
     */
    @jakarta.annotation.Resource
    private ResourceLoader resourceLoader;
    
    @jakarta.annotation.Resource
    private ApplicationContext appContext;
    
    /**
     * Injecting resource
     */
    @Value("classpath:data/employees.dat")
    private Resource resourceFile;
    
    /**
     * Data in data/employee.dat
     */
    private static final String EMPLOYEES_EXPECTED = "Joe Employee,Jan Employee,James T. Employee";
    
    @Test
    public void 使用ResourceLoaderLoadResource() throws IOException {
        final Resource resource = loadEmployeesWithResourceLoader();
        final String employees = new String(Files.readAllBytes(resource.getFile()
                                                                       .toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    @Test
    public void 使用ApplicationContextLoadResource() throws IOException {
        final Resource resource = loadEmployeesWithApplicationContext();
        final String employees = new String(Files.readAllBytes(resource.getFile()
                                                                       .toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    @Test
    public void 使用自动注入() throws IOException {
        final String employees = new String(Files.readAllBytes(resourceFile.getFile()
                                                                       .toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    @Test
    public void 使用spring的ResourceUtils() throws IOException {
        final File employeeFile = loadEmployeesWithSpringInternalClass();
        final String employees = new String(Files.readAllBytes(employeeFile.toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    @Test
    public void 使用spring的ClassPathResource读入InputStream() throws IOException {
        final InputStream resource = loadEmployeesWithClassPathResource().getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            final String employees = reader.lines()
                                             .collect(Collectors.joining("\n"));
            assertEquals(EMPLOYEES_EXPECTED, employees);
        }
    }
    
    @Test
    public void 使用spring的ClassPathResource读入File() throws IOException {
        final File resource = loadEmployeesWithClassPathResource().getFile();
        final String employees = new String(Files.readAllBytes(resource.toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    @Test
    public void 使用spring的ClassPathResource读取绝对路径() throws IOException {
        final File resource = new ClassPathResource("/data/employees.dat", this.getClass()).getFile();
        final String employees = new String(Files.readAllBytes(resource.toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    @Test
    public void 使用spring的ClassPathResource读取相对路径() throws IOException {
        final File resource = new ClassPathResource("../data/employees.dat", SpringResourceIntegrationTest.class).getFile();
        final String employees = new String(Files.readAllBytes(resource.toPath()));
        assertEquals(EMPLOYEES_EXPECTED, employees);
    }
    
    private File loadEmployeesWithSpringInternalClass() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:data/employees.dat");
    }
    
    private Resource loadEmployeesWithClassPathResource() {
        return new ClassPathResource("data/employees.dat");
    }
    
    private Resource loadEmployeesWithResourceLoader() {
        return resourceLoader.getResource("classpath:data/employees.dat");
    }
    
    private Resource loadEmployeesWithApplicationContext() {
        return appContext.getResource("classpath:data/employees.dat");
    }
}
