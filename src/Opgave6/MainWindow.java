package Opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 6");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        ListView<Car> carsList = new ListView<Car>();
        pane.add(carsList,0,0);
        Button btnAddCar = new Button("Tilføj bil");
        pane.add(btnAddCar, 0, 1);

        btnAddCar.setOnAction(event -> this.addCarAction());
    }

    private void addCarAction() {

    }


}
