package org.sql.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Converter {
	private String value;
    
	
	public double convert(String value) {
		double result = 0;
		String strQuantite = value.replaceAll("[^0-9.,]", "");
	    String unite = value.replaceAll("[0-9.,]", "");
	    
	    switch(unite) {
	    case "Kg" : result = Double.parseDouble(strQuantite)*1000;
                    break;
	    case "g" : result = Double.parseDouble(strQuantite);
	               break;
        default: 
        	result = Double.parseDouble(strQuantite);
	    }
		return result;
	}
}
