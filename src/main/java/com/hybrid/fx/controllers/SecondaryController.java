package com.hybrid.fx.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.mapper.DeptMapper;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.beans.factory.annotation.Autowired;

public class SecondaryController {

    @Inject ParticleApplication app;
    
    @Inject private ViewManager viewManager;

    @FXML
    private Button button;
    
    @FXML
    private ResourceBundle resources;
    
    private Action actionHome;
    
    @Autowired
    DeptMapper mapper;
    
    public void initialize() {
        ActionMap.register(this);
        actionHome =  ActionMap.action("goHome");
        
        button.setText(resources.getString("button.text"));
        button.setOnAction(e -> {
        	System.out.println(mapper.selectByDeptno(30));
        	viewManager.switchView("primary");	
        });
    }
    
    public void postInit() {
        app.getParticle().getToolBarActions().add(0, actionHome);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionHome);
    }
    
    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
}
