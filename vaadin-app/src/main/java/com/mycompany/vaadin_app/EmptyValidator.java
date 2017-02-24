package com.mycompany.vaadin_app;

import com.vaadin.data.Validator;

public class EmptyValidator implements Validator {
	
	private static final long serialVersionUID = -1286534740604950226L;
	
	private String fieldName;
	
	public  EmptyValidator(String fieldName){
		this.fieldName = fieldName;
	}

	public void validate(Object value) throws InvalidValueException {
		if(isValid(value))
			 throw new InvalidValueException("Please Fill "+fieldName+"!");
	}

	public boolean isValid(Object value) {
		String valueStr = (String)value;
		if(!valueStr.isEmpty())			
			return false;
		else
			return true;
	}

}
