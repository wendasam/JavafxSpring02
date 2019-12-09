package com.pawencode.latihanspring;

import com.pawencode.latihanspring.controller.AppController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavafxSpring02Application extends Application {

    private ApplicationContext springContext=null;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static String[] argument;

	@Override
	public void start(Stage primaryStage) throws Exception {
        Task<Object> task = new Task<Object>() {
            @Override
            protected Object call() throws Exception {
                logger.info("Loading project javaspringexample02");
                springContext = SpringApplication.run(JavafxSpring02Application.class, argument);
                return null;
            }
        };

        task.setOnSucceeded(event -> {
            AppController appController = springContext.getBean(AppController.class);
            Parent parent = (Parent) appController.initView();
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Java Spring Boot Latihan 02");
            primaryStage.show();
            logger.info("Loading project javaspringexample02 successfully");
        });

        task.setOnFailed(event -> {
            Platform.exit();
        });

        task.run();
	}

	public static void main(String[] args) {
		JavafxSpring02Application.argument = args;
		launch(args);
	}
}
