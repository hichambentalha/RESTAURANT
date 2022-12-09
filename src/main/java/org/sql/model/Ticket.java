package org.sql.model;

import java.util.List;

import org.sql.config.RecipeCatalog;
import org.sql.config.UnavailableDishException;
import org.sql.service.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

	private List<Dish> dishs;

	public Ticket and(String string) {

		String strIngredient[] = string.split(" ", 2);

		Dish dish = RecipeCatalog.dishs.stream().filter(d -> strIngredient[1].equals(d.getName())).findFirst()
				.orElse(null);
		dish.setQuantite(Integer.parseInt(strIngredient[0]));
		dishs.add(dish);

		if (Restaurant.checkStock(dish))
			return Ticket.builder().dishs(dishs).build();
		else
			throw new UnavailableDishException();
	}
}
