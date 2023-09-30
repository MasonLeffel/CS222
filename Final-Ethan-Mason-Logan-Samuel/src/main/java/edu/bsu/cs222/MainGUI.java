package edu.bsu.cs222;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.application.Application;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainGUI extends Application{

    public MainGUI() throws FileNotFoundException {
    }

    public static void main(String[] args){
        launch(args);
    }


    private final Insets INSETS = new Insets(10, 10, 10, 10);
    private final TextField inputField = new TextField();
    private final Button selectPhotoButton = createButton("Select Photo->");
    private final Button displayPhotoButton = createButton("Apply!");
    private final Button undoButton = createButton("Undo");
    private final Button downloadButton = createButton("Download");
    private final ColorPicker colorPicker = new ColorPicker();
    private final PhotoManager photoManager = new PhotoManager();
    private final ComboBox<String> filterSelector = new ComboBox<>();
    private ImageView imageView;
    Text errorMessage = new Text("");
    BorderPane root;


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        inputField.setText(new FilePicker().selectFile(primaryStage));
        buildUI(primaryStage);
        configureSelectPhotoButton();
        configureComboBox();
        configureDisplayPhotoButton();
        configureUndoButton();
        configureDownloadButton();
    }

    private void createRoot() throws FileNotFoundException {
        root = new BorderPane();
        updateImageView();
        setRoot();
    }
    private void buildUI(Stage stage) throws FileNotFoundException {

        createRoot();

        Scene scene = new Scene(root);
        stage.setTitle("Art Generator");
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(800);
        stage.show();
    }

    private void configureComboBox(){
        filterSelector.getItems().addAll("Blur", "Enlarge", "Shrink", "Outline", "Draw Edges", "Create B&W Image","Pixelate",
                "Stylize","Anime", "Paint", "Reset");}

    private void configureSelectPhotoButton() {
        selectPhotoButton.setOnAction(event -> {
            try {
                photoManager.selectPhoto(inputField.getText());
                updateImageView();
                setRoot();
            } catch (Exception e) {
                errorMessage.setText("Enter a valid file name. Make sure the image file is stored in resources folder.");
            }
        });
    }
    private void configureUndoButton() {
        undoButton.setOnAction(event -> {
            try {
                photoManager.revertDisplayImage();
                updateImageView();
                setRoot();
                System.out.println();
            } catch (Exception e) {
                errorMessage.setText("Make sure there is somewhere to revert to!");
            }
        });
    }
    private void configureDownloadButton() {
        downloadButton.setOnAction(event -> {
            try {
                photoManager.downloadImage();
                updateImageView();
                setRoot();
            } catch (Exception e) {
                errorMessage.setText("Could not download.");
            }
        });

    }
    private void configureDisplayPhotoButton() {
        displayPhotoButton.setOnAction(event -> {
            try {
                if (filterSelector.getValue().equals("Blur")) {
                    photoManager.blurImage();
                }
                else if (filterSelector.getValue().equals("Enlarge")){
                    photoManager.expandImage();
                }
                else if (filterSelector.getValue().equals("Reset")){
                    photoManager.selectPhoto(inputField.getText());
                }
                else if (filterSelector.getValue().equals("Create B&W Image")){
                    photoManager.blackAndWhiteImage();
                }
                else if (filterSelector.getValue().equals("Shrink")) {
                    photoManager.shrinkImage();
                }
                else if (filterSelector.getValue().equals("Pixelate")){
                    photoManager.pixelateImage();
                }
                else if (filterSelector.getValue().equals("Outline")){
                    photoManager.outlineImage();
                }
                else if (filterSelector.getValue().equals("Draw Edges")){
                    photoManager.defineEdges();
                }
                else if (filterSelector.getValue().equals("Stylize")){
                    photoManager.stylizeImage(colorPicker.getValue());
                }
                else if (filterSelector.getValue().equals("Paint")){
                    photoManager.paintImage();
                }
                else if (filterSelector.getValue().equals("Anime")){
                    photoManager.animeImage();
                }

                updateImageView();
                setRoot();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void updateImageView() throws FileNotFoundException {
        imageView = new ImageView(photoManager.getDisplayImage());
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);
    }

    private void setRoot(){
        errorMessage.setText("");
        VBox top = createVbox();
        top.getChildren().setAll(inputField, selectPhotoButton, errorMessage, colorPicker, filterSelector);
        root.setTop(top);


        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().setAll(displayPhotoButton, undoButton, downloadButton);
        root.setBottom(bottom);

        root.setCenter(imageView);
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMinWidth(150);
        BorderPane.setMargin(button, INSETS);
        BorderPane.setAlignment(button, Pos.CENTER);
        return button;
    }

    private VBox createVbox() {
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.setMaxHeight(Double.MAX_VALUE);
        vbox.setMinWidth(150);
        BorderPane.setMargin(vbox, INSETS);
        BorderPane.setAlignment(vbox, Pos.CENTER);
        return vbox;
    }

}