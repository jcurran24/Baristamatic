package com.trustwave.baristamatic.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.trustwave.baristamatic.entity.Ingredient;

public interface IngredientService {
	
	public int retrieveInventory(int ingredientId);
	public BigDecimal retrieveCost(int ingredientId);
	public Map<String, String> getIngredientPriceMap();
	public void restockIngredients();
	public Ingredient takeIngredient(int ingredientId);
	public List<Ingredient> retrieveAllIngredients();
}
