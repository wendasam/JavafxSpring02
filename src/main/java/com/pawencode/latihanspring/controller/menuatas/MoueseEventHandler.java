package com.pawencode.latihanspring.controller.menuatas;

import com.pawencode.latihanspring.iface.SpringBootInitial;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MoueseEventHandler implements SpringBootInitial {

    ApplicationContext applicationContext;

    double x, y;
    Stage stage;

    @FXML
    private BorderPane paneKiri;

    @FXML
    private BorderPane paneCenter;
    @FXML
    private StackPane stakpane;

    @FXML
    void dragged(MouseEvent event) {
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);

    }

    @FXML
    void pressed(MouseEvent event) {
        stage = (Stage) stakpane.getScene().getWindow();
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @Override
    public Node initView() {
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
