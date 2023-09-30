package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Stylize {

    private Color primary;
    private Color secondary;
    private Color tertiary;

    public Image stylize(Image img){
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int width = 0; width < ((int) img.getWidth()); width++) {
            for (int height = 0; height < ((int) img.getHeight()); height++) {
                Color sourceColor = reader.getColor(width, height);
                writer.setColor(width,height, getCorrectColor(sourceColor));
            }
        }
        return tmp;
    }

    public Color getCorrectColor(Color sourceColor){
        if (shouldSetPrimary(sourceColor))
            return primary;
        else if (shouldSetSecondary(sourceColor))
            return secondary;
        else if (shouldSetTertiary(sourceColor))
            return tertiary;

        //should never reach this line
        return Color.WHITE;
    }

    public void setColors(Color color){
        primary = color;
        secondary = new ColorWheel().getFirstComplementaryColor(color);
        tertiary = new ColorWheel().getSecondComplementaryColor(color);
    }

    public boolean shouldSetPrimary(Color color) {
        return color.getBrightness() <= 0.75 && color.getBrightness() >= 0.25;
    }

    public boolean shouldSetTertiary(Color color) {
        return color.getBrightness() > 0.75;
    }

    public boolean shouldSetSecondary(Color color) {
        return color.getBrightness() < .25;
    }
}
