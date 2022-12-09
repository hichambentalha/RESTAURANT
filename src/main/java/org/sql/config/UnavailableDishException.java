package org.sql.config;

public class UnavailableDishException extends RuntimeException {
	 
	    @Override
	    public String getMessage() {
	      return "Ingredient is out of our stock";
	    }
}
