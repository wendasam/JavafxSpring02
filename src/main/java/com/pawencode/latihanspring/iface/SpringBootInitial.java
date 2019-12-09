package com.pawencode.latihanspring.iface;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public interface SpringBootInitial extends Initializable, ApplicationContextAware, MessageSourceAware {

    public Node initView();

}
