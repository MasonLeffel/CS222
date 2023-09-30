package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BlurTest {

    @Test
    public void checkSameSize() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image blurredImage = new Blur().blur(testImage);

        Assertions.assertEquals(testImage.getWidth(), blurredImage.getWidth());
        Assertions.assertEquals(testImage.getHeight(), blurredImage.getHeight());
    }

    @Test
    public void checkMiddle() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();


        Color Pixel = blurredPixels.getColor(2, 2);

        Assertions.assertEquals(Pixel, Color.rgb(51, 51, 51));
    }

    @Test
    public void checkAverageSide() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        PixelReader testReader = testImage.getPixelReader();

        Assertions.assertEquals(new Blur().getBlurredColor(testReader, 2, 0), Color.rgb(68, 68, 68));
    }


}
