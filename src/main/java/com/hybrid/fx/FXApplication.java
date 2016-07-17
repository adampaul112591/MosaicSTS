package com.hybrid.fx;

import com.gluonhq.particle.application.ParticleApplication;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

import static org.controlsfx.control.action.ActionMap.actions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class FXApplication extends ParticleApplication {

    public FXApplication() {
        super("Gluon Desktop Application");
    }

    @Override
    public void postInit(Scene scene) {
        scene.getStylesheets().add(FXApplication.class.getResource("style.css").toExternalForm());

        setTitle("Gluon Desktop Application");

        getParticle().buildMenu("File -> [exit]", "Help -> [about]");
        
        getParticle().getToolBarActions().addAll(actions("---", "about", "exit"));
        
        setShowCloseConfirmation(false);
        
        Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("######################################");
				System.out.println("getPrimaryStage().setOnCloseRequest...");
				System.out.println("######################################");
				getPrimaryStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
					
					@Override
					public void handle(WindowEvent event) {
						close();
					}
				});
				
			}
		});
        
    }
    
    public static ConfigurableApplicationContext ctx;
    public static void close() {
    	System.out.println("##############");
    	System.out.println("ctx.close()...");
    	System.out.println("##############");
    	ctx.close();
    }
    
    public static void main(String[] args) {
    	ctx = SpringApplication.run(com.hybrid.MainApplication.class, args);
		launch(args);
	}
}