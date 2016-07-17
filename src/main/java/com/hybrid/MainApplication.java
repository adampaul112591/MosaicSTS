package com.hybrid;

import org.controlsfx.control.StatusBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.form.FormManager;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.util.Callback;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Autowired
	ApplicationContext appContext;
	
    @Bean
    public FXMLLoader provideFxmlLoader() {
        FXMLLoader loader = new FXMLLoader();

        loader.setControllerFactory(new Callback<Class<?>, Object>() {

			@Override
			public Object call(Class<?> param) {
				Object instance=null;
				try {
					instance = param.newInstance();
					appContext.getAutowireCapableBeanFactory().autowireBean(instance);
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return instance;
			}
		});
        return loader;
    }
    
	@Bean
	public Particle provideParticle() {
		System.out.println("provideParticle()...");
		return null;
	}
	
	@Bean
	public ParticleApplication provideParticleApplication() {
		System.out.println("provideParticleApplication()...");
		return null;
	}
	
	@Bean
	public ViewManager provideViewManager() {
		System.out.println("provideViewManager()...");
		return null;
	}

	@Bean
	public FormManager provideFormManager() {
		System.out.println("provideFormManager()...");
		return null;
	}
	
	@Bean
	public StateManager provideStateManager() {
		System.out.println("provideStateManager()...");
		return null;
	}	

	@Bean
	public MenuBar provideMenuBar() {
		System.out.println("provideMenuBar()...");
		return null;
	}	

	@Bean
	public ToolBar provideToolBar() {
		System.out.println("provideToolBar()...");
		return null;
	}

	@Bean
	public StatusBar provideStatusBar() {
		System.out.println("provideStatusBar()...");
		return null;
	}	
}

