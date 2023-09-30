package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AnimeTest {
    @Test
    public void testAverageWhite(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.WHITE);
        colorList.add(Color.WHITE);
        Assertions.assertEquals(Color.WHITE,new Anime().getAverage(colorList));
    }
    @Test
    public void testAverageGray(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.WHITE);
        colorList.add(Color.BLACK);
        Assertions.assertEquals(new Color(.5,.5,.5,1.0),new Anime().getAverage(colorList));
    }
    @Test
    public void testAverageThree(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.WHITE);
        colorList.add(Color.BLACK);
        colorList.add(new Color(.5,.5,.5,1.0));
        Assertions.assertEquals(new Color(.5,.5,.5,1.0),new Anime().getAverage(colorList));
    }

    @Test
    public void testSetBlackPixelsProcessedTrue() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        Assertions.assertTrue(animeTest.pixelProcessor.shouldProcess(2,2));

    }

    @Test
    public void testSetBlackPixelsProcessedFalse() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);
        Assertions.assertFalse(animeTest.pixelProcessor.shouldProcess(0,0));

    }

    @Test
    public void testCreateColorListFirstItem() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        ArrayList<Color> colorList = new ArrayList<>();
        ArrayList<Point> pointList = new ArrayList<>();
        animeTest.createColorGroup(1, 2, pointList, colorList);
        Assertions.assertEquals(Color.WHITE, colorList.get(0));

    }

    @Test
    public void testCreateColorListFourthItem() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        ArrayList<Color> colorList = new ArrayList<>();
        ArrayList<Point> pointList = new ArrayList<>();
        animeTest.createColorGroup(1, 2, pointList, colorList);
        Assertions.assertEquals(Color.WHITE, colorList.get(3));

    }

    @Test
    public void testCreatePointListFirstItem() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        ArrayList<Color> colorList = new ArrayList<>();
        ArrayList<Point> pointList = new ArrayList<>();
        animeTest.createColorGroup(1, 2, pointList, colorList);
        Assertions.assertEquals(new Point(1,2), pointList.get(0));

    }

    @Test
    public void testCreatePointListFourthItem() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        ArrayList<Color> colorList = new ArrayList<>();
        ArrayList<Point> pointList = new ArrayList<>();
        animeTest.createColorGroup(1, 2, pointList, colorList);
        Assertions.assertEquals(new Point(2,3), pointList.get(3));

    }

    @Test
    public void testItemNotInColorGroup() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        ArrayList<Color> colorList = new ArrayList<>();
        ArrayList<Point> pointList = new ArrayList<>();
        animeTest.createColorGroup(1, 2, pointList, colorList);
        Assertions.assertFalse(pointList.contains(new Point(2,1)));

    }
}
