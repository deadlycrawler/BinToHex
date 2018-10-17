package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        //sets the window title
        primaryStage.setTitle("hex goes on top, binary on the bottom");


        //text field to enter hex to convert to binary
        TextArea textArea = new TextArea();
        textArea.setPromptText("Enter up to 8 digit hex codes here, separated by a space");

        //text field to enter binary to convert to hex
        TextArea textArea2 = new TextArea();
        textArea2.setPromptText("Enter up to 31 Bit binary values here, separated by a space");


        //button to convert hex to bianry
        Button DisplayBinaryButton = new Button("Click to Convert to binary");
        DisplayBinaryButton.setMinWidth(50);

        //button to convert binary to hex
        Button DisplayHexButton = new Button("Click to Convert to hex");
        DisplayBinaryButton.setMinWidth(50);


        //on click function the Binary button
        DisplayBinaryButton.setOnAction(action -> {
            DisplayBinary(textArea, textArea2);

        });
        //on click function the Hex button
        DisplayHexButton.setOnAction(action -> {
            DispalyHex(textArea, textArea2);

        });
        //just stacked all the text boxes and such into a VBOX
        VBox vbox = new VBox(DisplayBinaryButton, textArea, DisplayHexButton, textArea2);


        //standard Gui building
        int windowWidth = 720;
        int windowHeight = windowWidth / 16 * 9;

        Scene scene = new Scene(vbox, windowWidth, windowHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

        //ensures graceful program closure
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    //heler method to aid in conversion
    void DisplayBinary(TextArea textArea, TextArea textArea2) {


        textArea2.setText(convertToBin(textArea.getText()));
    }

    //heler method to aid in conversion
    void DispalyHex(TextArea textArea, TextArea textArea2) {


        textArea.setText(convertToHex(textArea2.getText()));
    }


    //converts string that was extracted from text box and converts it and puts it in the next text box
    String convertToHex(String BinaryString) {

        //removes unessicary spaces and new lines that were casing problems
        BinaryString = BinaryString.replace("\n", " ");
        BinaryString = BinaryString.trim();
        BinaryString = BinaryString.replace("  ", " ");


        //puts string into an array seperated by spaces
        String[] SeparatedBinary = BinaryString.split(" ");


        String Hex = "";

        //loop through array elements converting
        for (int i = 0; i < SeparatedBinary.length; i++) {

            try {
                int decimal = Integer.parseInt(SeparatedBinary[i], 2);
                Hex = Hex + Integer.toString(decimal, 16) + " ";
            } catch (NumberFormatException e) {
                Hex = "Check formatting";
                break;
            }

            if (i % 40 == 0 && i != 0) {

                Hex += "\n";
            }
        }
        //tidys up spaces at the end to avoid errors caused by excessive spaces
        Hex = Hex.trim();

        return Hex;
    }

    //converts string that was extracted from text box and converts it and puts it in the next text box
    String convertToBin(String HexString) {

        //removes unessicary spaces and new lines that were casing problems
        HexString = HexString.replace("\n", " ");
        HexString = HexString.trim();
        HexString = HexString.replace("  ", " ");

        //puts string into an array seperated by spaces
        String[] SeperatedHex = HexString.split(" ");
        String Bin = "";

        //loop through array elements converting
        for (int i = 0; i < SeperatedHex.length; i++) {


            try {
                Bin = Bin + Integer.toBinaryString(Integer.parseInt(SeperatedHex[i], 16)) + " ";
            } catch (NumberFormatException e) {
                Bin = "Check formatting";
                break;
            }

            if (i % 10 == 0 && i != 0) {

                Bin += "\n";
            }
        }
        Bin = Bin.trim();


        return Bin;
    }
}


