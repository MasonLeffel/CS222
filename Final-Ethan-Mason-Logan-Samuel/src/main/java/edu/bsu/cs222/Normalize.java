package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Normalize {

    public Image normalize(Image img){
        PixelReader reader = img.getPixelReader();
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelWriter writer = tmp.getPixelWriter();
        for (int width=0; width < img.getWidth(); width++) {
            for (int height = 0; height < img.getHeight(); height++) {
                writer.setColor(width, height,getRoundedColor(reader.getColor(width, height)));
            }
        }
        return tmp;
    }


    public int getRoundedValue(int x) {
       int y = x/50;
       int remainder =x%50;
       if (remainder > 25){
           return y*50 + 50;
       }
       return y*50;
    }

    public Color getRoundedColor(Color color) {
        return Color.rgb(getRoundedValue((int) (color.getRed()*255)), getRoundedValue((int) (color.getGreen()*255)),
                getRoundedValue((int) (color.getBlue()*255)));
    }
}
