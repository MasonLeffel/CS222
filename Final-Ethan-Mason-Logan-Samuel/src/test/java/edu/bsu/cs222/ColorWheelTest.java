package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorWheelTest {

    @Test
    public void CheckFirstComplementaryColorHue0(){
        Color TestColor = Color.hsb(0, 1.0, 1.0);
        Color SecondaryColor = new ColorWheel().getFirstComplementaryColor(TestColor);

        Assertions.assertEquals(150, SecondaryColor.getHue());

    }

    @Test
    public void CheckFirstComplementaryColorHue300(){
        Color TestColor = Color.hsb(300, 1.0, 1.0);
        Color SecondaryColor = new ColorWheel().getFirstComplementaryColor(TestColor);

        Assertions.assertEquals(90, SecondaryColor.getHue());

    }

    @Test
    public void CheckSecondaryComplementaryColorHue0(){
        Color TestColor = Color.hsb(0, 1.0, 1.0);
        Color SecondaryColor = new ColorWheel().getSecondComplementaryColor(TestColor);

        Assertions.assertEquals(210, SecondaryColor.getHue());

    }

    @Test
    public void CheckSecondaryComplementaryColorHue300(){
        Color TestColor = Color.hsb(300, 1.0, 1.0);
        Color SecondaryColor = new ColorWheel().getSecondComplementaryColor(TestColor);

        Assertions.assertEquals(150, SecondaryColor.getHue());

    }
}
