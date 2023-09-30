package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackAndWhiteTest {

    @Test
    public void shouldBlackOrWhiteWithWhite(){

        Color test = Color.rgb(0,0,0);
        Assertions.assertEquals(Color.WHITE, new BlackAndWhite().blackOrWhite(test));
    }
    @Test
    public void shouldBlackOrWhiteWithBlack(){

        Color test = Color.rgb(255,255,255);
        Assertions.assertEquals(Color.WHITE, new BlackAndWhite().blackOrWhite(test));
    }
    @Test
    public void shouldBlackOrWhiteWithGrey(){

        Color test = Color.GRAY;
        Assertions.assertEquals(Color.BLACK, new BlackAndWhite().blackOrWhite(test));
    }
}
