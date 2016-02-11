package com.trustwave.baristamatic.service;

import java.math.BigDecimal;
import java.util.Map;

import com.trustwave.baristamatic.enumtype.IngredientType;

public interface IngredientService {
	
	public int retrieveInventory(IngredientType ingredientType);
	public BigDecimal retrieveCost(IngredientType ingredientType);
	public Map<String, String> getIngredientPriceMap();
}
