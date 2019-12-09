package com.pawencode.latihanspring.controller;

import com.jfoenix.controls.JFXButton;
import com.pawencode.latihanspring.config.AppConfig;
import com.pawencode.latihanspring.controller.menulogin.LoginController;
import com.pawencode.latihanspring.iface.SpringBootInitial;

import com.pawencode.latihanspring.controller.menuKiri.PanelKiriController;
import com.pawencode.latihanspring.controller.menuUtama.AddNewDataController;
import com.pawencode.latihanspring.controller.menuatas.MoueseEventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AppController implements SpringBootInitial {

    @FXML private ApplicationContext springContext;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @FXML private BorderPane paneKiri, paneCenter;

    @FXML @Autowired private AddNewDataController addNewDataController;
    @FXML @Autowired private PanelKiriController panelKiriController;
    @FXML @Autowired private LogController logController;
    @FXML @Autowired private LoginController loginController;

    @FXML private JFXButton btLog;

    @FXML
    void viewLog(ActionEvent event) {
        setMenuTengah(logController.initView());
    }

    @Override
    public Node initView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(AppConfig.MENU_UTAMA));
            loader.setController(springContext.getBean(this.getClass()));
            this.logger.info("Successfully load main windowd");
            //logController.getLoggerTextArea().appendText("Successfully load main windowd");
            return loader.load();
        } catch (Exception e) {
            this.logger.error("Error load Main Window");
            return null;
        }

    }

    private void setMenuKiri(Node node) {
        paneKiri.getChildren().clear();
        paneKiri.setCenter(node);
        paneKiri.autosize();
    }

    public void setMenuTengah(Node node) {
        paneCenter.getChildren().clear();
        paneCenter.setCenter(node);
        paneCenter.autosize();
    }

    public void setLogWindow() {
        setMenuTengah(this.logController.initView());
    }

    private void showPanelKiri() {
        setMenuKiri(this.panelKiriController.initView());
    }

    public TextArea getVisualLog() {
        return logController.getLoggerTextArea();
    }

    public void showPanelCenter() {
//        setMenuTengah(this.addNewDataController.initView());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.showPanelKiri();
        this.showPanelCenter();
        //this.logController = new LogController();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext = applicationContext;
        //MoueseEventHandler moueseEventHandler = springContext.getBean(MoueseEventHandler.class);
        //moueseEventHandler.setApplicationContext(springContext);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }


}
