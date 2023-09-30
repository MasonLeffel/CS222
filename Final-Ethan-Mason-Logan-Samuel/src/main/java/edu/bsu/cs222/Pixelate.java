package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Pixelate {

    public Image pixelate(Image img){
        PixelReader reader = img.getPixelReader();
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelWriter writer = tmp.getPixelWriter();
        for (int width=0; width < img.getWidth(); width += 10) {
            for (int height = 0; height < img.getHeight(); height += 10) {
                setAverage(writer, width, height, getAveragePixels(reader, width, height));
            }
        }
        return tmp;
    }
    public Color getAveragePixels(PixelReader reader, int baseWidth, int baseHeight) {
        double averageRed = 0.0;
        double averageGreen = 0.0;
        double averageBlue = 0.0;
        int numPixels = 0;
        for (int addedWidth=0; addedWidth <= 10; addedWidth++) {
            for (int addedHeight = 0; addedHeight <= 10; addedHeight++) {
                try {
                    averageRed += reader.getColor(baseWidth + addedWidth, baseHeight + addedHeight).getRed();
                    averageGreen += reader.getColor(baseWidth + addedWidth, baseHeight + addedHeight).getGreen();
                    averageBlue += reader.getColor(baseWidth + addedWidth, baseHeight + addedHeight).getBlue();
                    numPixels++;
                }
                catch (IndexOutOfBoundsException ignored){

                }
            }
        }
        averageRed = averageRed/numPixels;
        averageGreen =averageGreen/numPixels;
        averageBlue = averageBlue/numPixels;
        return new Color(averageRed, averageGreen, averageBlue, 1.0);
    }

    public void setAverage(PixelWriter testWriter, int baseWidth, int baseHeight, Color color) {
        for (int addedWidth=0; addedWidth <= 10; addedWidth++) {
            for (int addedHeight = 0; addedHeight <= 10; addedHeight++) {
                try {
                    testWriter.setColor(baseWidth+addedWidth, baseHeight+addedHeight, color);
                }
                catch (IndexOutOfBoundsException ignored){

                }
            }
        }
    }
}
