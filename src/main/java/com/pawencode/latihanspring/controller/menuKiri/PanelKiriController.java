package com.pawencode.latihanspring.controller.menuKiri;

import com.jfoenix.controls.JFXButton;
import com.pawencode.latihanspring.config.AppConfig;
import com.pawencode.latihanspring.controller.AppController;
import com.pawencode.latihanspring.controller.LogController;
import com.pawencode.latihanspring.controller.menuUtama.AddNewDataController;
import com.pawencode.latihanspring.controller.menulogin.LoginController;
import com.pawencode.latihanspring.iface.SpringBootInitial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class PanelKiriController implements SpringBootInitial {

    private ApplicationContext springContext;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @FXML @Autowired LogController logController;
    @FXML @Autowired AppController appController;
    @FXML @Autowired LoginController loginController;
    @FXML @Autowired private AddNewDataController addNewDataController;

    @FXML private AnchorPane desktopPane;

    @FXML private JFXButton btDesktop, btLaptop, btAndroid, btMac, btWindows, btLinux;

    @FXML
    void btLogPressed(MouseEvent event) {
        try {
            //appController.setMenuTengah(logController.initView());
            appController.setMenuTengah(this.addNewDataController.initView());
            logController.getLoggerTextArea().appendText("Add window showed");
        }catch (Exception e) {

        }
    }

    @FXML
    void laptopAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(AppConfig.ADD_NEW_DATA));
        Parent parent = loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Add New Data");
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    void onLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(AppConfig.VIEW_LOGIN));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public Node initView() {
        try {
            this.logger.info("Load panel kiri");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(AppConfig.PANEL_KIRI));
            loader.setController(springContext.getBean(this.getClass()));
            return loader.load();
        } catch (Exception e) {
            this.logger.error("Error Load panel kiri: " + e);
            return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext = applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
