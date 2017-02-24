package com.mycompany.vaadin_app;

import com.mycompany.vaadin_app.model.Employee;
import com.mycompany.vaadin_app.model.IEmployee;
import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
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
	
	private final IEmployee employee = new Employee();
	
	
	
	
    @Override
    public void onBrowserDetailsReady() {
    	loginView();
    }
    
    
    private void loginView(){
    	Panel loginPanel = new Panel("Login Form");
    	loginPanel.setWidth("50%");
    	GridLayout grid = new GridLayout(1,3);
    	grid.setWidth("100%");
//    	Label usernameLbl = new Label("username");
    	usernameTfl = new TextField("username");
    	usernameTfl.setWidth("100%");
//    	grid.addComponent(usernameLbl, 0, 0);
    	grid.addComponent(usernameTfl, 0, 0);
    	
//    	Label passLbl = new Label("password");
    	passTfl = new PasswordField("password"); 
    	passTfl.setWidth("100%");
//    	grid.addComponent(passLbl, 0, 1);
    	grid.addComponent(passTfl, 0, 1);
    	
    	Button loginBtn = new Button("Login", this);
    	loginBtn.setWidth("100%");

    	grid.addComponent(loginBtn, 0, 2);
    	
    	loginPanel.addComponent(grid);
    	
    	getMainWindow().addComponent(loginPanel);
    	 
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
