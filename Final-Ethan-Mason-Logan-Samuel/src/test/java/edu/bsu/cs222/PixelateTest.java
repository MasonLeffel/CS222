package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PixelateTest {
    @Test
    public void checkAverageWhite() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_White.png"));
        PixelReader testReader = testImage.getPixelReader();

        Color Pixel = new Pixelate().getAveragePixels(testReader, 0, 0);
        Assertions.assertEquals(Pixel, Color.WHITE);
    }
    @Test
    public void checkAverageGray() throws FileNotFoundException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_HafWhite_HafBlack.png"));
        PixelReader testReader = testImage.getPixelReader();

        Color grayAverage = new Pixelate().getAveragePixels(testReader,0,0);
        Assertions.assertEquals( new Color(.5,.5,.5,1.0), grayAverage);
    }
    @Test
    public void checkSetAverageWhite() throws FileNotFoundException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_HafWhite_HafBlack.png"));
        PixelReader testReader = testImage.getPixelReader();
        WritableImage tmp = new WritableImage(testReader, (int) testImage.getWidth(), (int)testImage.getHeight());
        PixelWriter testWriter = tmp.getPixelWriter();


        new Pixelate().setAverage(testWriter,0,0, Color.WHITE);
        Assertions.assertEquals(Color.WHITE, new Pixelate().getAveragePixels(tmp.getPixelReader(), 0,0));
    }

    @Test
    public void checkSetAverageBlack() throws FileNotFoundException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_HafWhite_HafBlack.png"));
        PixelReader testReader = testImage.getPixelReader();
        WritableImage tmp = new WritableImage(testReader, (int) testImage.getWidth(), (int)testImage.getHeight());
        PixelWriter testWriter = tmp.getPixelWriter();


        new Pixelate().setAverage(testWriter,0,0, Color.BLACK);
        Assertions.assertEquals(Color.BLACK, new Pixelate().getAveragePixels(tmp.getPixelReader(), 0,0));
    }
}
