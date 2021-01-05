import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest extends TestCase {
    @Override
    protected void setUp() throws Exception {

    }
    public void testGetFolderSize() {
        long expected = 60108971;

        File folder = new File("G:/java_basics-master");
        long actual = Main.getFolderSizeRecursive(folder);

        assertEquals(expected, actual);
    }

    public void testGetFolderSizeJava8() throws IOException {
        long expected = 60108971;

        Path pathFolder = Paths.get("G:/java_basics-master");
        long actual = Main.getFolderSizeJava8(pathFolder);

        assertEquals(expected, actual);
    }
}
