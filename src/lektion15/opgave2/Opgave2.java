package lektion15.opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave2 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private int number = 0;
    private final Label lblnewNum = new Label();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNumber = new Label("Nummer: ");
        pane.add(lblNumber, 0, 1);

        pane.add(lblnewNum, 1, 1);
        lblnewNum.setText("" + number);


        Button btnAddition = new Button("+1");
        pane.add(btnAddition, 1, 0);
        Button btnSubtraction = new Button("-1");
        pane.add(btnSubtraction, 1, 2);

        btnAddition.setOnAction(event -> this.additionAction());

        btnSubtraction.setOnAction(event -> this.subtractionAction());
    }

    private void additionAction() {
        number++;
        lblnewNum.setText("" + number);
    }

    private void subtractionAction() {
        number--;
        lblnewNum.setText("" + number);
    }
}