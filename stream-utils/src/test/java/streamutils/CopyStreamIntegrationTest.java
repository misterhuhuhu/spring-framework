package streamutils;

import org.assertj.core.util.Files;
import org.junit.jupiter.api.Test;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static classpathfileaccess.streamutils.CopyStream.getStringFromInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CopyStreamIntegrationTest {
    
    @Test
    public void InputStream到OutputStream() throws IOException {
        File outFile = Files.newTemporaryFile();
        String inputFileName = "src/test/resources/input.txt";
        InputStream in = new FileInputStream(inputFileName);
        OutputStream out = new FileOutputStream(outFile);
        
        StreamUtils.copy(in, out);
        
        assertTrue(outFile.exists());
        String inputFileContent = getStringFromInputStream(new FileInputStream(inputFileName));
        String outputFileContent = getStringFromInputStream(new FileInputStream(outFile));
        assertEquals(inputFileContent, outputFileContent);
        
    }
    
    @Test
    public void InputStream到OutputStream从1到10() throws IOException {
        String inputFileName = "src/test/resources/input.txt";
        File outFile = Files.newTemporaryFile();
        InputStream in = new FileInputStream(inputFileName);
        OutputStream out = new FileOutputStream(outFile);
        
        StreamUtils.copyRange(in, out, 1, 10);
        
        assertTrue(outFile.exists());
        String inputFileContent = getStringFromInputStream(new FileInputStream(inputFileName));
        String outputFileContent = getStringFromInputStream(new FileInputStream(outFile));
        assertEquals(inputFileContent.substring(1, 11), outputFileContent);
    }
    
    @Test
    public void 从字符串到OutputStream() throws IOException {
        String string = "Should be copied to OutputStream.";
        File outFile = Files.newTemporaryFile();
        OutputStream out = new FileOutputStream("src/test/resources/output.txt");
        
        StreamUtils.copy(string, StandardCharsets.UTF_8, out);
        
        assertTrue(outFile.exists());
        String outputFileContent = getStringFromInputStream(new FileInputStream(outFile));
        assertEquals(outputFileContent, string);
    }
    
    @Test
    public void InputStream到字符串() throws IOException {
        String inputFileName = "src/test/resources/input.txt";
        InputStream is = new FileInputStream(inputFileName);
        String content = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
        
        String inputFileContent = getStringFromInputStream(new FileInputStream(inputFileName));
        assertEquals(inputFileContent, content);
    }
    
    @Test
    public void ByteArray到OutputStream() throws IOException {
        String outputFileName = "src/test/resources/output.txt";
        String string = "Should be copied to OutputStream.";
        byte[] byteArray = string.getBytes();
        OutputStream out = new FileOutputStream("src/test/resources/output.txt");
        
        StreamUtils.copy(byteArray, out);
        String outputFileContent = getStringFromInputStream(new FileInputStream(outputFileName));
        assertEquals(outputFileContent, string);
    }
    
    @Test
    public void InputStream到ByteArray() throws IOException {
        String inputFileName = "src/test/resources/input.txt";
        InputStream in = new FileInputStream(inputFileName);
        byte[] out = StreamUtils.copyToByteArray(in);
        
        String content = new String(out);
        String inputFileContent = getStringFromInputStream(new FileInputStream(inputFileName));
        assertEquals(inputFileContent, content);
    }
    
}
