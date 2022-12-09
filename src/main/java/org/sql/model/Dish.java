package org.sql.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dish {
	private String name;
	private Map<String, String> ingredients;
	private int preparationTime;
	private int cookingTime;
	private int bakingTime;
	private int quantite;

}
