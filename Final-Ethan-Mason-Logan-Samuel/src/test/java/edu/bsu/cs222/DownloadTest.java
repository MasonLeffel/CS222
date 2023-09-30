package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DownloadTest {


    @Test
    public void testGetModifiedFileDirectory(){
        String testDirectory = System.getProperty("user.dir") + "/src/resources/test.png";
        String returnedDirectory = new Download().getModifiedFileDirectory(testDirectory);

        Assertions.assertEquals(System.getProperty("user.dir") + "/src/resources/test_modified.png", returnedDirectory);
    }
}
