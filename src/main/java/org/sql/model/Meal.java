package org.sql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

	Ticket ticket;

	public int servedDishes() {
		int total = 0;
		total = (ticket.getDishs().stream().mapToInt(i -> i.getQuantite())).sum();

		return total;
	}

	public String cookingDuration() {
		int total = 0;
		for (Dish d : ticket.getDishs()) {
			if (d.getQuantite() > 1) {
				total += d.getPreparationTime() + ((d.getPreparationTime() / 2) * (d.getQuantite() - 1));
			} else
				total = d.getPreparationTime();
		}
		return Integer.toString(total);
	}

}
