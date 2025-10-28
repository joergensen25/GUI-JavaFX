package lektion16.opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    private final TextField txfTitle = new TextField();
    private final TextField txfName = new TextField();
    private final CheckBox chkSenior = new CheckBox("Senior");
    private final ListView<Person> lvwPersons = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 1, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        pane.add(txfTitle, 1, 1);


        pane.add(chkSenior, 1, 2);

        Button btnAdd = new Button("Add person");
        pane.add(btnAdd, 2, 2);

        Button btnRemove = new Button("Remove person");
        pane.add(btnRemove, 2, 3);

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 3);

        pane.add(lvwPersons, 1, 3);

        btnAdd.setOnAction(event -> this.addAction());

        btnRemove.setOnAction(actionEvent -> this.removeAction());

    }

    private void removeAction() {
        Person selectedPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            lvwPersons.getItems().remove(selectedPerson);
        }
    }
    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = chkSenior.isSelected();
        Person newPerson = new Person(name, title, senior);

        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("Type the name of the person");
            alert.show();
        } else if (title.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("Type the title of the person");
            alert.show();
        } else {
            lvwPersons.getItems().add(newPerson);
        }
    }
}
