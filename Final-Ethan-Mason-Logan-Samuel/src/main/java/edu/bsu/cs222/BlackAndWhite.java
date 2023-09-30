package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class BlackAndWhite {
    public Image blackAndWhite(Image img) {
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();

        for (int x = 0; x < ((int) img.getWidth()); x++) {
            for (int y = 0; y < ((int) img.getHeight()); y++) {
                Color sourceColor = reader.getColor(x, y);
                writer.setColor(x, y, blackOrWhite(sourceColor));
            }
        }
        return tmp;
    }

    public Color blackOrWhite(Color sourceColor){
        if (sourceColor.getBrightness() <= 0.75 && sourceColor.getBrightness() >= 0.25)
            return Color.BLACK;
        return Color.WHITE;
    }
}
