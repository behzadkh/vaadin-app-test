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
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends TouchKitApplication implements ClickListener
{
	
	private TextField usernameTfl;
	
	private PasswordField passTfl;
	
	private final Employee employee = new Employee();
	
	
	
	
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
    	
    	
    	
    	formLayout.addComponent(hLayout1);
    	formLayout.addComponent(hLayout2);
    	formLayout.addComponent(loginBtn);
    	
    	
    	
    	 getMainWindow().addComponent(formLayout);
    	 
    	
    	
    }


	public void buttonClick(ClickEvent event) {
		
		String errorMessage = "";
		boolean login = true;
		
		String username = (String)usernameTfl.getValue();
		String password = (String)passTfl.getValue();
		username = username.trim();
		password = password.trim();
		
		if(username.isEmpty()){
			errorMessage += "<li >Please Enter Username...</li>" ;
			login = false;
		}
		if(password.isEmpty()){
			errorMessage += "<li >Please Enter password...</li>";
			login = false;
		}
		if(login){
			
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setNumberOfLoginClick(employee.numberOfLoginClick()+1);
			String loginMsg = " You clicked "+employee.numberOfLoginClick() + " time(s) on login button!";			
			Notification errorNotification = new Notification("<p style=\"color:green;\">Login</p>",loginMsg, Notification.TYPE_HUMANIZED_MESSAGE);
			errorNotification.setPosition( Window.Notification.POSITION_CENTERED);
			getMainWindow().showNotification(errorNotification);
		}
		else {
			Notification errorNotification = new Notification("<p style=\"color:red;\">Error</p>",errorMessage.toString(), Notification.TYPE_ERROR_MESSAGE);
			errorNotification.setPosition( Notification.POSITION_CENTERED);
			getMainWindow().showNotification(errorNotification);
		}
		
	}

    
}
