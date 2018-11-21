import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Test extends Application {
    static ColourPalette colourPalette = new ColourPalette(10);
    static Colour chosenColour;


    public static void main(String[] args) {

        Colour colour1 = new Colour(255, 255, 255);
        Colour colour2 = new Colour(255, 220, 110);
        Colour colour3 = new Colour(255, 255, 255);
        Colour colour4 = new Colour(50, 70, 120);
        Colour colour5 = new Colour(255, 255, 255);

        colourPalette.addColour(colour1);
        colourPalette.addColour(colour2);
        colourPalette.addColour(colour3);
        colourPalette.addColour(colour4);
        colourPalette.addColour(colour5);
        System.out.println(colourPalette.getNumberOfGrayColours());

        colourPalette.mixColour(0, new Colour(255, 200, 100));

        System.out.println(colourPalette.getNumberOfGrayColours());

        System.out.println(colourPalette.toString());
        colourPalette.mixColour(0, new Colour(250, 255, 255));
        System.out.println(colourPalette.toString());

        System.out.println(colourPalette.getNumberOfGrayColours());

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("leg med farver!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));


        //rød farve indput
        Label labelred = new Label("type in a value for red");
        GridPane.setConstraints(labelred, 0, 0);

        TextField textfieldred = new TextField("red");
        GridPane.setConstraints(textfieldred, 1, 0);

        grid.getChildren().addAll(labelred, textfieldred);

        //grøn farve input
        Label labelgreen = new Label("type in a value for green");
        GridPane.setConstraints(labelgreen, 0, 1);

        TextField textFieldgreen = new TextField("green");
        GridPane.setConstraints(textFieldgreen, 1, 1);

        grid.getChildren().addAll(labelgreen, textFieldgreen);

        //blå farve
        Label labelblue = new Label("type in a value for blue");
        GridPane.setConstraints(labelblue, 0, 2);

        TextField textFieldblue = new TextField("blue");
        GridPane.setConstraints(textFieldblue, 1, 2);

        grid.getChildren().addAll(labelblue, textFieldblue);

        TextArea textArea = new TextArea();
        GridPane.setConstraints(textArea, 1, 3);

        grid.getChildren().addAll(textArea);

        //combobox
        ComboBox colours = new ComboBox();
        for (int i = 0; i < colourPalette.getColours().size(); i++) {
            colours.getItems().add(colourPalette.getColours().get(i));
        }


        colours.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    if(colours.getValue() != null) {
                                        chosenColour = (Colour) colours.getValue();
                                        textArea.appendText(chosenColour.toString() + "\n");
                                    }


                                }
                            }
        );
        GridPane.setConstraints(colours, 1, 6);

        grid.getChildren().addAll(colours);

        Button button1 = new Button();
        button1.setText("calculate");
        grid.add(button1, 1, 7);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Colour tempColor = (Colour) colours.getValue();

                double result1 = tempColor.getRed();
                double fieldresult1 = Double.valueOf(textfieldred.getText());
                double resultred = (result1 + fieldresult1) / 2;

                double result2 = tempColor.getGreen();
                double fieldresult2 = Double.valueOf(textFieldgreen.getText());
                double resultgreen = (result2 + fieldresult2) / 2;

                double result3 = tempColor.getBlue();
                double fieldresult3 = Double.valueOf(textFieldblue.getText());
                double resultblue = (result3 + fieldresult3) / 2;

                Colour colour = new Colour(fieldresult1, fieldresult2, fieldresult3);

                tempColor.mixWith(colour);

                colours.getItems().clear();
                for (int i = 0; i < colourPalette.getColours().size(); i++) {
                    colours.getItems().addAll(colourPalette.getColours().get(i));
                }

                System.out.println(resultred + "\n" + resultgreen + "\n" + resultblue);
                textArea.appendText("red = " + resultred + "\n" + "green = " + resultgreen + "\n" + "blue = " + resultblue + "\n");
            }
        });
        Button button2 = new Button();
        button2.setText("number of gray colours");
        grid.add(button2, 1, 8);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value = String.valueOf(colourPalette.getNumberOfGrayColours() + "\n");
                textArea.appendText(value);
            }
        });
        Button button3 = new Button();
        button3.setText("delete selected colour");
        grid.add(button3, 1, 9);
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(chosenColour != null && colours.getItems() != null) {
                    colourPalette.getColours().remove(chosenColour);
                    colours.getItems().clear();
                    for (int i = 0; i < colourPalette.getColours().size(); i++) {
                        colours.getItems().addAll(colourPalette.getColours().get(i));
                    }


                }

            }
        });
        



        Scene scene = new Scene(grid, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
