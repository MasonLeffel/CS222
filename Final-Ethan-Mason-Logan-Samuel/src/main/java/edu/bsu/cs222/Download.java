package edu.bsu.cs222;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Download {

    public void download(Image displayImage, String fileDirectory) throws IOException {
        ImageIO.write(SwingFXUtils.fromFXImage(displayImage, null), "png", new File(getModifiedFileDirectory(fileDirectory)));
    }

    public String getModifiedFileDirectory(String inputDir){
        String tmp = "";
        if (inputDir.contains(".")){
            tmp += inputDir.substring(0,inputDir.indexOf("."));
            tmp += "_modified";
            tmp += inputDir.substring(inputDir.indexOf("."));
        }
        return tmp;
    }
}
