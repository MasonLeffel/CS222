package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeTest {

    @Test
    public void checkSetBlack() {
        Color test1 = Color.rgb(0,0,0);
        Color test2 = Color.rgb(255,255,255);
        Assertions.assertTrue(new Edge().shouldSetBlack( test1, test2, 0.5));
    }

    @Test
    public void checkSetWhite(){
        Color test1 = Color.rgb(0,0,0);
        Color test2 = Color.rgb(0,0,0);
        Assertions.assertFalse(new Edge().shouldSetBlack( test1, test2, 0.5));
    }

    @Test
    public void checkSimilarColor(){
        Color test1 = new Color(.5,.5,.5, 1.0);
        Color test2 = new Color(.5,.5,1.0,1.0);
        Assertions.assertFalse(new Edge().shouldSetBlack(test1, test2, 0.5));
    }

    @Test
    public void checkDistantColor(){
        Color test1 = new Color(.5,.5,.5, 1.0);
        Color test2 = new Color(.55,.75,.75,1.0);
        Assertions.assertTrue(new Edge().shouldSetBlack(test1, test2, 0.5));
    }
}