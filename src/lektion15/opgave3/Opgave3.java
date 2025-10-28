package lektion15.opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static java.lang.Math.pow;

public class Opgave3 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 3");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    int sum = 0;
    private final TextField txfIndskud = new TextField(); // 1, 0
    private final TextField txfRente = new TextField();
    private final TextField txfAntalR = new TextField();
    private final Label lblFremtidigVærdiHolder = new Label(); // 1, 4

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblIndskud = new Label("Indskud"); // 0, 0
        pane.add(lblIndskud, 0, 0);
        Label lblRente = new Label("Rente (%)"); // 0, 1
        pane.add(lblRente, 0, 1);

        Label lblAntalR = new Label("Antal rentetilskrivninger"); // 0, 2
        pane.add(lblAntalR, 0, 2);

        Label lblFremtidigVærdi = new Label("Fremtidig værdi"); // 0, 4
        pane.add(lblFremtidigVærdi, 0, 4);


        pane.add(lblFremtidigVærdiHolder, 1, 4);

        Button btnBeregn = new Button("Beregn"); // 1, 3
        pane.add(btnBeregn, 1, 3);

        btnBeregn.setDefaultButton(true);
        pane.add(txfIndskud, 1, 0);
        pane.add(txfRente, 1, 1);
        pane.add(txfAntalR, 1, 2);

        btnBeregn.setOnAction(event -> this.beregnAction());
    }

    private void beregnAction() {

        String strIndskud = txfIndskud.getText();
        String strRente = txfRente.getText();
        String strAntalR = txfAntalR.getText();

        int indskud = Integer.parseInt(strIndskud);
        double rente = Double.parseDouble(strRente) / 100;
        int antalR = Integer.parseInt(strAntalR);


        double sum = indskud * pow((1 + rente), antalR);

        lblFremtidigVærdiHolder.setText(String.format("%.2f", sum));


    }
}