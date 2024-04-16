package eu.rabow.bdd.ui;

import eu.rabow.bdd.Reservierung;
import eu.rabow.bdd.Restaurant;
import eu.rabow.bdd.Tisch;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantReservationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Restaurant restaurant = new Restaurant(2);

        Button btn = new Button();
        btn.setText("Reservieren");
        btn.setOnAction(event -> {
            Reservierung reservierung = restaurant.reserviere();
            if (reservierung != null) {
                System.out.println("Reservierung war an Tisch " + reservierung.getTisch().getNummer());
            } else {
                System.out.println("Kein Tisch frei");
            }
        });

        VBox tischList = new VBox();
        for (Tisch tisch : restaurant.getTische()) {
            TischViewModel tischViewModel = new TischViewModel(tisch);

            HBox tischBox = new HBox();
            Label tischLabel = new Label("Tisch " + tischViewModel.getNummer());
            Label freiePlaetzeLabel = new Label();
            freiePlaetzeLabel.textProperty().bind(Bindings.concat("Freie Plätze: ").concat(tischViewModel.freiePlaetzeProperty()));
            tischBox.getChildren().addAll(tischLabel, freiePlaetzeLabel);
            tischList.getChildren().add(tischBox);
        }

        VBox root = new VBox(tischList, btn);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Restaurant Reservations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}