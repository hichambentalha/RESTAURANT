package org.sql.service;

import org.sql.model.Meal;
import org.sql.model.Ticket;

public interface IRestaurant {
	
  public Ticket order(String string);
  public Meal retrieve(Ticket ticket);

  
}
