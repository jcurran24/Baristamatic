package com.trustwave.baristamatic.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.trustwave.baristamatic.entity.Drink;

public interface DrinkService {

	public List<Drink> retrieveAllDrinks();
	public boolean isInStock(Drink drink);
	public BigDecimal calculatedDrinkCost(Drink drink);
	public boolean isDrinkChoice(char choice);
	public Drink vendDrink(int drinkChoice);
}
