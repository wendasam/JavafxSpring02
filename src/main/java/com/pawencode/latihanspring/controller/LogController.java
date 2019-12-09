package com.pawencode.latihanspring.controller;

import com.pawencode.latihanspring.config.AppConfig;
import com.pawencode.latihanspring.iface.SpringBootInitial;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LogController implements SpringBootInitial {

    @FXML private TextArea loggerTextArea;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ApplicationContext springContext;

    public TextArea getLoggerTextArea() {
        return loggerTextArea;
    }

    @Override
    public Node initView() {
        try {
            logger.info("Successfully load log window");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(AppConfig.VIEW_LOG));
            loader.setController(springContext.getBean(this.getClass()));
            return loader.load();
        } catch (Exception e) {
            logger.error("Failed to load log window");
        }
        return null;
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
