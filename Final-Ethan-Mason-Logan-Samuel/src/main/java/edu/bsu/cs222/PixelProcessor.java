package edu.bsu.cs222;

import javafx.scene.image.Image;

public class PixelProcessor {
    Boolean[][] processedList;
    public PixelProcessor(Image img) {
        processedList = new Boolean [(int)img.getWidth()] [(int)img.getHeight()];
        for (int horizontalPosition = 0; horizontalPosition<(int)img.getWidth(); horizontalPosition++){
            for (int verticalPosition = 0; verticalPosition<(int)img.getHeight(); verticalPosition++){
                processedList[horizontalPosition][verticalPosition] = true;
            }
        }
    }

    public boolean shouldProcess(int horizontalPosition, int verticalPosition) {
        if (horizontalPosition >= processedList.length || horizontalPosition < 0 || verticalPosition>= processedList[1].length || verticalPosition < 0)
            return false;
        return processedList[horizontalPosition][verticalPosition];
    }

    public void setProcessed(int horizontalPosition, int verticalPosition) {
        processedList[horizontalPosition][verticalPosition] = false;
    }


}
