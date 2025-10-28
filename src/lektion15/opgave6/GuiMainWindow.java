package lektion15.opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiMainWindow extends Application {

    private final ListView<Car> lvwCars = new ListView<>();

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
        pane.add(lvwCars,0,0);
        Button btnAddCar = new Button("Tilføj bil");
        pane.add(btnAddCar, 0, 1);

        btnAddCar.setOnAction(event -> new GuiCreateCarWindow(lvwCars));
    }


}
