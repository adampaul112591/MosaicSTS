package com.hybrid.fx.views;

import javax.inject.Inject;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.fx.FXApplication;
import com.hybrid.fx.controllers.PrimaryController;

import javafx.fxml.FXMLLoader;

@ParticleView(name = "primary", isDefault = true)
public class PrimaryView extends FXMLView {
    
    public PrimaryView() {
        super(PrimaryView.class.getResource("primary.fxml"));
    }
    
    @Inject
    FXMLLoader fxmlLoader;
    
    @Override
	public void init() {
    	/***************
    	 * Spring Boot
    	 ***************/
    	fxmlLoader.setControllerFactory(FXApplication.ctx.getBean(FXMLLoader.class).getControllerFactory());
	}


	@Override
    public void start() {
        ((PrimaryController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((PrimaryController) getController()).dispose();
    }
    
}
