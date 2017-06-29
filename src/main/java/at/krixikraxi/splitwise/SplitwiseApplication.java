package at.krixikraxi.splitwise;

import at.krixikraxi.splitwise.views.MainView;
import com.airhacks.afterburner.injection.Injector;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SplitwiseApplication extends Application {

    private static final Logger log = LoggerFactory.getLogger(SplitwiseApplication.class);
    private ConfigurableApplicationContext context;
    private static String[] args;

    public static void main(String[] args) {
        //SpringApplication.run(SplitwiseApplication.class);
        //launch(args);
        LauncherImpl.launchApplication(SplitwiseApplication.class, args);
    }

    @Override
    public void init() throws Exception {
        if(null == args){
            args = new String[]{""};
        }
        context = SpringApplication.run(SplitwiseApplication.class, args);
        Injector.setInstanceSupplier(aClass -> context.getBean(aClass));
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
