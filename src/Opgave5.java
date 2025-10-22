import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave5 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 5");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextArea txaList = new TextArea();
    private final TextField txfName = new TextField();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Navn"); // 0, 0
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        pane.add(txaList,0,4);

        Button btnAddName = new Button("Tilføj navn"); // 0, 2
        pane.add(btnAddName, 0, 2);
        btnAddName.setDefaultButton(true);

        Button btnClear = new Button("Clear");
        pane.add(btnClear, 1, 2);



        btnAddName.setOnAction(event -> this.addNameAction());
        btnClear.setOnAction(event -> this.clearAction());
    }

    private void clearAction() {
        txaList.clear();
    }

    private void addNameAction() {
        String name = txfName.getText().trim();
        txaList.appendText(name + "\n");
        txfName.clear();
    }
}
