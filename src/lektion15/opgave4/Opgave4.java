package lektion15.opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave4 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 4");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private final TextField txfCelsius = new TextField(); // 0, 1
    private final TextField txfFahrenheit = new TextField(); // 2, 1

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblCelcius = new Label("Celsius"); // 0, 0
        pane.add(lblCelcius, 0, 0);
        Label lblFahrenheit = new Label("Fahrenheit"); // 2, 0
        pane.add(lblFahrenheit, 2, 0);

        pane.add(txfCelsius, 0, 1);
        pane.add(txfFahrenheit, 2, 1);


        Button cToF = new Button(">>"); // 1, 0
        pane.add(cToF, 1, 0);
        Button fToC = new Button("<<"); // 1, 1
        pane.add(fToC, 1, 1);

        cToF.setOnAction(event -> this.cToFAction());

        fToC.setOnAction(event -> this.fToCAction());
    }

    private void cToFAction() {
        double celsius = Double.parseDouble(txfCelsius.getText());

        double result = 1.8 * celsius + 32;

        txfFahrenheit.setText(String.format("%.1f", result));
    }

    private void fToCAction() {
        double fahrenheit = Double.parseDouble(txfFahrenheit.getText());

        double result = (fahrenheit - 32) * 1.8;

        txfCelsius.setText(String.format("%.1f", result));
    }

}
