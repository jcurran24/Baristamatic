package com.trustwave.baristamatic.service;

import java.math.BigDecimal;
import java.util.List;

import com.trustwave.baristamatic.entity.Drink;

public interface DrinkService {

	public List<Drink> retrieveAllDrinks();
	public boolean isInStock(Drink drink);
	public BigDecimal calculatedDrinkCost(Drink drink);
}
