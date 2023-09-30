package edu.bsu.cs222;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResizeTest {

    @Test
    public void checkExpandSizeHeight() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new ResizeImage().expand(testImage, 2);

        Assertions.assertEquals(testImage.getHeight() * 2, expandedImage.getHeight());
    }
    @Test
    public void checkExpandSizeWidth() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new ResizeImage().expand(testImage, 2);

        Assertions.assertEquals(testImage.getWidth() * 2, expandedImage.getWidth());
    }

    @Test
    public void checkPixelPreservedExpand() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Color sample1 = testImage.getPixelReader().getColor((int) testImage.getWidth() / 2, (int) testImage.getHeight() / 2);
        Image expandedImage = new ResizeImage().expand(testImage, 2);
        Color sample2 = expandedImage.getPixelReader().getColor((int) expandedImage.getWidth() / 2, (int) expandedImage.getHeight() / 2);

        Assertions.assertEquals(sample1, sample2);
    }

    @Test
    public void checkExpandCapHeight() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/black_image.png"));
        Image expandedImage = new ResizeImage().expand(testImage, 4);

        Assertions.assertEquals(testImage.getHeight(), expandedImage.getHeight());
    }
    @Test
    public void checkExpandCapWidth() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/black_image.png"));
        Image expandedImage = new ResizeImage().expand(testImage, 4);

        Assertions.assertEquals(testImage.getWidth(), expandedImage.getWidth());
    }


    @Test
    public void checkShrinkSizeHeight() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new ResizeImage().shrink(testImage, 2);

        Assertions.assertEquals(testImage.getHeight() / 2, expandedImage.getHeight());
    }

    @Test
    public void checkShrinkSizeWidth() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new ResizeImage().shrink(testImage, 2);

        Assertions.assertEquals(testImage.getWidth() / 2, expandedImage.getWidth());
    }

    @Test
    public void checkPixelPreservedShrink() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Color sample1 = testImage.getPixelReader().getColor((int) testImage.getWidth() / 2, (int) testImage.getHeight() / 2);
        Image shrunkImage = new ResizeImage().shrink(testImage, 2);
        Color sample2 = shrunkImage.getPixelReader().getColor((int) shrunkImage.getWidth() / 2, (int) shrunkImage.getHeight() / 2);

        Assertions.assertEquals(sample1, sample2);
    }

    @Test
    public void checkShrinkSizeCapHeight() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        Image expandedImage = new ResizeImage().shrink(testImage, 6);

        Assertions.assertEquals(testImage.getHeight(), expandedImage.getHeight());
    }

    @Test
    public void checkShrinkSizeCapWidth() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        Image expandedImage = new ResizeImage().shrink(testImage, 6);

        Assertions.assertEquals(testImage.getWidth(), expandedImage.getWidth());
    }
}

