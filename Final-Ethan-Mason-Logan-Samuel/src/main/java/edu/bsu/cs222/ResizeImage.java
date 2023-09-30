package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ResizeImage {

    public javafx.scene.image.Image expand(javafx.scene.image.Image img, int resizeFactor){
        if ((int)img.getWidth() * resizeFactor > 4000 || (int)img.getHeight() * resizeFactor >4000){
            return img;
        }
        WritableImage temporaryImage = new WritableImage((int)img.getWidth()*resizeFactor, (int)img.getHeight()*resizeFactor);
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = temporaryImage.getPixelWriter();
        for (int horizontalPosition = 0;horizontalPosition<(int)img.getWidth(); horizontalPosition++){
            for (int verticalPosition = 0;verticalPosition<(int)img.getHeight(); verticalPosition++){
                Color sourceColor = reader.getColor(horizontalPosition,verticalPosition);
                expandColorIntoNewSquare(writer, horizontalPosition, verticalPosition, resizeFactor, sourceColor);
            }
        }

        return temporaryImage;
    }
    public void expandColorIntoNewSquare(PixelWriter writer, int baseHorizontalPosition, int baseVerticalPosition, int resizeFactor, Color color){
        for (int addedWidth = 0;addedWidth<resizeFactor; addedWidth++) {
            for (int addedHeight = 0; addedHeight < resizeFactor; addedHeight++) {
                writer.setColor(baseHorizontalPosition * 2 + addedWidth, baseVerticalPosition * 2 + addedHeight, color);
            }
        }
    }

    public Image shrink(Image img, int resizeFactor) {
        if (img.getWidth() <= resizeFactor || img.getHeight() <= resizeFactor)
            return img;

        WritableImage tmp = new WritableImage((int)img.getWidth()/resizeFactor, (int)img.getHeight()/resizeFactor);
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int width = 0;width<(int)tmp.getWidth(); width++){
            for (int height = 0;height<(int)tmp.getHeight(); height++){
                Color sourceColor = reader.getColor(width*resizeFactor,height*resizeFactor);
                writer.setColor(width, height, sourceColor);

            }
        }

        return tmp;
    }
}

