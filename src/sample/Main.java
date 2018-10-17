package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("hex goes on top, binary on the bottom");

        TextArea textArea = new TextArea();

        TextArea textArea2 = new TextArea();


        Button DisplayBinaryButton = new Button("Click to Convert to binary");
        DisplayBinaryButton.setMinWidth(50);

        Button DisplayHexButton = new Button("Click to Convert to hex");
        DisplayBinaryButton.setMinWidth(50);

        DisplayBinaryButton.setOnAction(action -> {
            DisplayBinary(textArea, textArea2);

        });

        DisplayHexButton.setOnAction(action -> {
            DispalyHex(textArea, textArea2);

        });

        VBox vbox = new VBox(textArea, DisplayBinaryButton, DisplayHexButton, textArea2);

        Scene scene = new Scene(vbox, 1300, 1000 / 16 * 9);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    void DisplayBinary(TextArea textArea, TextArea textArea2) {

        System.out.println(textArea.getText());
        textArea2.setText(convertToBin(textArea.getText()));
    }

    void DispalyHex(TextArea textArea, TextArea textArea2) {

        System.out.println(textArea2.getText());
        textArea.setText(convertToHex(textArea2.getText()));
    }

    String convertToHex(String BinaryString) {
        BinaryString = BinaryString.replace("\n"," ");
        BinaryString = BinaryString.replace("  "," ");
        String[] SeparatedBinary = BinaryString.split(" ");


        String Hex = "";

        for (int i = 0; i < SeparatedBinary.length; i++) {
            int decimal = Integer.parseInt(SeparatedBinary[i], 2);
            Hex = Hex + Integer.toString(decimal, 16) + " ";
        }
        return Hex;
    }

    String convertToBin(String HexString) {
        HexString = HexString.replace("\n"," ");
        HexString = HexString.replace("  "," ");
        String[] SeperatedHex = HexString.split(" ");
        String Bin = "";

        for (int i = 0; i < SeperatedHex.length; i++) {


            Bin = Bin + Integer.toBinaryString(Integer.parseInt(SeperatedHex[i], 16)) + " ";

            if (i % 10 == 0 && i != 0) {

                Bin += "\n";
            }
        }


        return Bin;
    }
}


