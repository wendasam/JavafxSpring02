package com.pawencode.latihanspring.controller.menulogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.pawencode.latihanspring.config.AppConfig;
import com.pawencode.latihanspring.controller.AppController;
import com.pawencode.latihanspring.iface.SpringBootInitial;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
public class LoginController implements SpringBootInitial {

    @FXML private ApplicationContext springContext;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @FXML private JFXButton btLogin, btCancel;
    @FXML private TextField txUname;
    @FXML private PasswordField txPass;

    @Override
    public Node initView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(AppConfig.VIEW_LOGIN));
            loader.setController(springContext.getBean(this.getClass()));
            this.logger.info("Successfully load main windowd");
            //logController.getLoggerTextArea().appendText("Successfully load main windowd");
            return loader.load();
        } catch (Exception e) {
            this.logger.error("Error load login Window");
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
