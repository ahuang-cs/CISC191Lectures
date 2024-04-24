package edu.sdccd.cisc191.springjpajavafxdemo;

import edu.sdccd.cisc191.springjpajavafxdemo.model.Option;
import edu.sdccd.cisc191.springjpajavafxdemo.model.Vehicle;
import edu.sdccd.cisc191.springjpajavafxdemo.services.VehicleService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaJavaFxDemoApplication extends Application {
    public ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(SpringJpaJavaFxDemoApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VehicleService vehicleService = springContext.getBean(VehicleService.class);
        stage.setTitle("Vehicles");
        VBox root = new VBox();

        for(Vehicle vehicle: vehicleService.findAll()) {
            Button btn = new Button();
            btn.setText(vehicle.getManufacturerName());
            btn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Vehicle Info");
                alert.setHeaderText("Options");
                alert.setContentText(vehicle.getOptionsAsString());
                alert.show();
            });
            root.getChildren().add(btn);
        }

        stage.setScene(new Scene(root, 300, 250));
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(SpringJpaJavaFxDemoApplication.class);

        VehicleService vehicleService = springContext.getBean(VehicleService.class);
        Option moonroof = new Option("moonroof");
        vehicleService.save(moonroof);
        Option ledLights = new Option("led lights");
        vehicleService.save(ledLights);

        List<Option> options = new ArrayList<>();
        options.add(moonroof);
        options.add(ledLights);

        Vehicle ford = new Vehicle("Ford Fiesta", 30000, 9999, 5, options);
        vehicleService.save(ford);
        Vehicle toyota = new Vehicle("Toyota Supra", 300, 79999, 4, null);
        vehicleService.save(toyota);

        for(Vehicle vehicle: vehicleService.findAll()) {
            System.out.println(vehicle.toString());
        }
    }

    public Server inMemoryDBServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
