package at.krixikraxi.splitwise;

import at.krixikraxi.splitwise.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication extends Application {

    private static final Logger log = LoggerFactory.getLogger(SplitwiseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new MainView().getView()));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        primaryStage.setTitle("SplitWise MainView");
        primaryStage.show();

        log.debug("Primary Stage up!");
    }
}
