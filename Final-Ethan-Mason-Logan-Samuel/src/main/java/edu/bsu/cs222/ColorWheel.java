package edu.bsu.cs222;

import javafx.scene.paint.Color;

public class ColorWheel {

    public Color getFirstComplementaryColor(Color color){
        double hue = color.getHue() + 150.0;
        if (hue > 360){hue -= 360;}

        return Color.hsb(hue, color.getSaturation(), color.getBrightness());
    }

    public Color getSecondComplementaryColor(Color color) {
        double hue = color.getHue() + 210.0;
        if (hue > 360){hue -= 360;}

        return Color.hsb(hue, color.getSaturation(), color.getBrightness());
    }

}
