package org.sql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sql.config.Converter;
import org.sql.config.RecipeCatalog;
import org.sql.config.UnavailableDishException;
import org.sql.model.Dish;
import org.sql.model.Ingredient;
import org.sql.model.Meal;
import org.sql.model.Ticket;

public class Restaurant implements IRestaurant {

	static List<Ingredient> stock;
	Meal meal;
	private List<Dish> dishsToPrepare;
	private List<Dish> allRecipeCatalogs;
	static Converter converter = new Converter();

	public Restaurant(String... parameters) {
		stock = new ArrayList<>();
		for (String param : parameters)
			supplyStock(param);
		allRecipeCatalogs = RecipeCatalog.dishs;
	}

	public void supplyStock(String str) {
		String nameIngredient;
		double quantite = 999;

		String strIngredient[] = str.split(" ", 2);

		boolean numeric = true;
		numeric = strIngredient[0].matches("-?\\d+(\\.\\d+)?");
		if (numeric) {
			quantite = Double.parseDouble(strIngredient[0]);
			nameIngredient = strIngredient[1];
		} else if (Character.isDigit(strIngredient[0].charAt(0))) {
			quantite = converter.convert(strIngredient[0]);
			nameIngredient = strIngredient[1];
		} else {
			nameIngredient = str;
		}

		stock.add(Ingredient.builder().name(nameIngredient).quantite(quantite).build());
	}

	public static boolean checkStock(Dish dish) {
		
		double quantityRequired = 1;

		for (Map.Entry<String, String> entry : dish.getIngredients().entrySet()) {
			String nameIngredient = entry.getKey();
			String strQuantityRequired = entry.getValue();

			Ingredient i = stock.stream().filter(d -> nameIngredient.equals(d.getName())).findFirst().orElse(null);

			boolean numeric = true;
			numeric = strQuantityRequired.matches("-?\\d+(\\.\\d+)?");
			if (numeric) {
				quantityRequired = Double.parseDouble(strQuantityRequired);
			} else if (Character.isDigit(strQuantityRequired.charAt(0))) {
				quantityRequired = converter.convert(strQuantityRequired);
			}

			if (dish.getQuantite() * quantityRequired > i.getQuantite()) {
				return false;
			}

		}

		return true;
	}

	@Override
	public Ticket order(String string) {
		dishsToPrepare = new ArrayList<>();
		String strIngredient[] = string.split(" ", 2);

		Dish dish = allRecipeCatalogs.stream().filter(d -> strIngredient[1].equals(d.getName())).findFirst().orElse(null);
		dish.setQuantite(Integer.parseInt(strIngredient[0]));
		dishsToPrepare.add(dish);
		if (checkStock(dish))
			return Ticket.builder().dishs(dishsToPrepare).build();
		else
			throw new UnavailableDishException();
	}

	@Override
	public Meal retrieve(Ticket ticket) {
		return new Meal(ticket);
	}
}
