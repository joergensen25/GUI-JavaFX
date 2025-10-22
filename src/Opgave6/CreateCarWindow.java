package Opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateCarWindow extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Opret bil");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    private final TextField txfPrice = new TextField();
    private final TextField txfModel = new TextField();
    private final CheckBox chkElectric = new CheckBox();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblBrand = new Label("Mærke"); // 0, 0
        pane.add(lblBrand, 0, 0);

        Label lblModel = new Label("Model"); // 0, 1
        pane.add(lblModel, 0, 1);

        Label lblElectric = new Label("Elektrisk"); // 0, 2
        pane.add(lblElectric, 0, 2);

        Label lblPrice = new Label("Pris per dag"); // 0, 3
        pane.add(lblPrice, 0, 3);

        ComboBox<String> cmbBrand = new ComboBox<>();
        pane.add(cmbBrand, 1, 0);

        pane.add(txfModel, 1, 1);

        pane.add(chkElectric, 1, 2);

        pane.add(txfPrice, 1, 3);

        Button btnCreate = new Button("Opret");
        pane.add(btnCreate, 1, 4);

        btnCreate.setOnAction(event -> this.createAction());
    }

    private void createAction() {
        String strModel = txfModel.getText();

        int pricePerDay = Integer.parseInt(txfPrice.getText());
        if (chkElectric.isSelected()) {
            String electric = "(Elbil)";
        }
    }
}
