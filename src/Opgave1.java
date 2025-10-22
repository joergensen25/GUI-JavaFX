import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave1 extends Application {
        @Override
        public void start(Stage stage) {
            stage.setTitle("Opgave 1");
            GridPane pane = new GridPane();
            this.initContent(pane);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }


        private final TextField txfFirstName = new TextField();
        private final TextField txfLastName = new TextField();
        private final TextField txfFullName = new TextField();

        private void initContent (GridPane pane) {
            pane.setGridLinesVisible(false);
            pane.setPadding(new Insets(20));
            pane.setHgap(10);
            pane.setVgap(10);

            Label lblFirstName = new Label("Fornavn");
            Label lblLastName = new Label("Efternavn");
            Label lblFullName = new Label("Fulde navn");

            pane.add(lblFirstName, 0, 0);
            pane.add(lblLastName, 1, 0);
            pane.add(lblFullName, 0, 2);

            pane.add(txfFirstName, 0, 1);
            pane.add(txfLastName, 1,1);
            pane.add(txfFullName, 0, 3, 2,1);

            Button btnCombine = new Button("Kombiner");
            pane.add(btnCombine, 1, 4);
            GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

            btnCombine.setOnAction(event -> this.combineAction());

        }

        private void combineAction() {
            String first = txfFirstName.getText().trim();
            String last = txfLastName.getText().trim();

            String fullName = first + " " + last;
            txfFullName.setText(fullName);
        }

        }

