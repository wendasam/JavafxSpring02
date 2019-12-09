package com.pawencode.latihanspring.controller.menuUtama;

import com.pawencode.latihanspring.config.AppConfig;
import com.pawencode.latihanspring.iface.SpringBootInitial;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AddNewDataController implements SpringBootInitial {

    private ApplicationContext springContext;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Node initView() {
        try {
            this.logger.info("Load panel kiri");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(AppConfig.ADD_NEW_DATA));
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
