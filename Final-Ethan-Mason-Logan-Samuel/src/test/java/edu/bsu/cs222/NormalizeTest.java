package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javafx.scene.paint.Color;


public class NormalizeTest {

    @Test
    public void check254() {
        int x= 254;
        int returnValue = new Normalize().getRoundedValue(x);
        Assertions.assertEquals(250, returnValue);
    }

    @Test
    public void  check75(){
        int x=75;
        int returnValue = new Normalize().getRoundedValue(x);
        Assertions.assertEquals(50, returnValue);
    }
    @Test
    public void  check76(){
        int x=76;
        int returnValue = new Normalize().getRoundedValue(x);
        Assertions.assertEquals(100, returnValue);
    }
    @Test
    public void checkGetRoundedBlack(){
        Color testColor = Color.BLACK;
        Color returnedColor= new Normalize().getRoundedColor(testColor);

        Assertions.assertEquals(Color.BLACK, returnedColor);
    }

    @Test
    public void checkGetRoundedWhite(){
        Color testColor = Color.WHITE;
        Color returnedColor= new Normalize().getRoundedColor(testColor);
        Assertions.assertEquals(Color.rgb(250,250,250), returnedColor);
    }
    @Test
    public void checkGetRoundedBlue(){
        Color testColor = Color.BLUE;
        Color returnedColor= new Normalize().getRoundedColor(testColor);
        Assertions.assertEquals(Color.rgb(0,0,250), returnedColor);
    }
}


