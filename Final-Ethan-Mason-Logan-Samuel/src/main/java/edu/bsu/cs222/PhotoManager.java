package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PhotoManager {
    private Image displayImage;
    private final ArrayList<Image> imageHistory = new ArrayList<>();
    private int count = -1;
    private String sourceDir;

    public PhotoManager() throws FileNotFoundException {
        sourceDir = System.getProperty("user.dir") + "/src/resources/black_image.png";
        selectPhoto(sourceDir);

    }

    public void selectPhoto(String fileLocation) throws FileNotFoundException {
        sourceDir = fileLocation;
        displayImage = new Image(new FileInputStream(fileLocation));
        addDisplayImage();
    }

    public Image getDisplayImage(){
        return displayImage;
    }

    private void addDisplayImage(){
        try {
            count ++;
            imageHistory.add(count, displayImage);
        }
        catch (Exception e){
            count ++;
        }
    }
    public void revertDisplayImage(){
        count -= 1;
        displayImage = imageHistory.get(count);
    }

    public void blurImage() throws IOException {
        displayImage = new Blur().blur(displayImage);
        addDisplayImage();
    }

    public void expandImage(){
        displayImage = new ResizeImage().expand(displayImage, 2);
        addDisplayImage();
    }
    public void shrinkImage(){
        displayImage = new ResizeImage().shrink(displayImage, 2);
        addDisplayImage();
    }
    public void pixelateImage(){
        displayImage = new Pixelate().pixelate(displayImage);
        addDisplayImage();
    }
    public void blackAndWhiteImage(){
        displayImage = new BlackAndWhite().blackAndWhite(displayImage);
        addDisplayImage();
    }
    public void outlineImage(){
        displayImage = new Edge().createOutline(displayImage);
        addDisplayImage();
    }
    public void defineEdges(){
        displayImage = new Edge().defineEdge(displayImage);
        addDisplayImage();
    }
    public void stylizeImage(Color color){
        Stylize stylizeEngine = new Stylize();
        stylizeEngine.setColors(color);
        displayImage = stylizeEngine.stylize(displayImage);
        addDisplayImage();
    }

    public void paintImage() throws IOException{
        displayImage = new Normalize().normalize(displayImage);
        addDisplayImage();
    }
    public void animeImage(){
        Anime animeFilter = new Anime(displayImage);

        animeFilter.setLines(new BlackAndWhite().blackAndWhite(displayImage));
        animeFilter.setLines(new Edge().createOutline(displayImage));
        displayImage = animeFilter.getAnimeImage();
        addDisplayImage();
    }
    public void downloadImage() throws IOException {
        new Download().download(displayImage, sourceDir);
    }


}
