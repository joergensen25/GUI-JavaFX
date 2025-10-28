package lektion15.opgave6;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiCreateCarWindow {

    private final ComboBox<String> cmbBrand = new ComboBox<>();
    private final TextField txfPrice = new TextField();
    private final TextField txfModel = new TextField();
    private final CheckBox chkElectric = new CheckBox("Elektrisk");
    private final ListView<Car> lvwCars;

    public GuiCreateCarWindow(ListView<Car> lvwCars) {
        this.lvwCars = lvwCars;

        Stage stage = new Stage();
        stage.setTitle("Opret bil");

        GridPane pane = new GridPane();
        this.initContent(pane, stage);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane, Stage stage) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Brand/Mærke
        Label lblBrand = new Label("Mærke"); // 0, 0
        pane.add(lblBrand, 0, 0);
        cmbBrand.getItems().addAll("Tesla", "Porsche", "Audi", "BMW", "Volkswagen");
        pane.add(cmbBrand, 1, 0);

        // Model
        Label lblModel = new Label("Model"); // 0, 1
        pane.add(lblModel, 0, 1);
        pane.add(txfModel, 1, 1);

        // Elektrisk?
        pane.add(chkElectric, 1, 2);

        // Pris per dag
        Label lblPrice = new Label("Pris per dag"); // 0, 3
        pane.add(lblPrice, 0, 3);
        pane.add(txfPrice, 1, 3);

        Button btnCreate = new Button("Opret");
        pane.add(btnCreate, 1, 4);

        btnCreate.setOnAction(event -> this.createAction(stage));
    }

    private void createAction(Stage stage) {

        String brand = cmbBrand.getValue();
        String model = txfModel.getText().trim();
        boolean electric = chkElectric.isSelected();
        double pricePerDay = Double.parseDouble(txfPrice.getText().trim());

        Car newCar = new Car(brand, model, electric, pricePerDay);
        lvwCars.getItems().add(newCar);
        stage.close();
    }
}
