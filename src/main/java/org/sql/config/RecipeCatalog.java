package org.sql.config;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import org.sql.model.Dish;

public class RecipeCatalog {

	public static List<Dish> dishs = List.of(

			new Dish("Tomato Mozzarella Salad",
					Map.ofEntries(new AbstractMap.SimpleEntry<String, String>("balls Mozzarella", "1"),
							new AbstractMap.SimpleEntry<String, String>("tomatoes", "2"),
							new AbstractMap.SimpleEntry<String, String>("olive oil", "1")),
					6, 0, 0, 0),
			new Dish("Pizza",
					Map.ofEntries(new AbstractMap.SimpleEntry<String, String>("balls Mozzarella", "1"),
							new AbstractMap.SimpleEntry<String, String>("tomatoes", "4"),
							new AbstractMap.SimpleEntry<String, String>("water", "100cl"),
							new AbstractMap.SimpleEntry<String, String>("Flour", "300g"),
							new AbstractMap.SimpleEntry<String, String>("sea salt", "1")),
					0, 10, 10, 0),
			new Dish("Lasagna",
					Map.ofEntries(new AbstractMap.SimpleEntry<String, String>("balls Mozzarella", "0.5"),
							new AbstractMap.SimpleEntry<String, String>("tomatoes", "4"),
							new AbstractMap.SimpleEntry<String, String>("olive oil", "1"),
							new AbstractMap.SimpleEntry<String, String>("sheet of lasagna pasta", "3"),
							new AbstractMap.SimpleEntry<String, String>("lean beef mince", "200g")),
					0, 5, 30, 0));

}
