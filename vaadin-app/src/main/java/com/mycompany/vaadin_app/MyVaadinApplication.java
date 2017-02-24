package com.mycompany.vaadin_app;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends TouchKitApplication implements ClickListener
{
	
	private TextField usernameTfl;
	
	private PasswordField passTfl;
	
	private final Employee employee = new Employee();
	
	private Label numberOfLoginLbl;
	
    @Override
    public void onBrowserDetailsReady() {
    	loginView();
    }
    
    
    private void loginView(){
    	FormLayout formLayout = new FormLayout();
    	
    	
    	Label usernameLbl = new Label("username");
    	usernameTfl = new TextField();    	
    	HorizontalLayout hLayout1 = new HorizontalLayout();    	
    	hLayout1.addComponent(usernameLbl);
    	hLayout1.addComponent(usernameTfl);
    	
    	Label passLbl = new Label("password");
    	passTfl = new PasswordField(); 
    	HorizontalLayout hLayout2 = new HorizontalLayout();
    	hLayout2.addComponent(passLbl);
    	hLayout2.addComponent(passTfl);
    	
    	Button loginBtn = new Button("Login", this);
    	
    	numberOfLoginLbl = new Label();
    	
    	formLayout.addComponent(hLayout1);
    	formLayout.addComponent(hLayout2);
    	formLayout.addComponent(loginBtn);
    	formLayout.addComponent(numberOfLoginLbl);
    	
    	
    	 getMainWindow().addComponent(formLayout);
    	
    }


	public void buttonClick(ClickEvent event) {
		String username = (String)usernameTfl.getValue();
		String password = (String)passTfl.getValue();
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setNumberOfLoginClick(employee.numberOfLoginClick()+1);
		numberOfLoginLbl.setCaption("You clicked "+employee.numberOfLoginClick() + " time(s) on login button!");
	}

    
}
