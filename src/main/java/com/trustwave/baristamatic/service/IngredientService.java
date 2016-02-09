package com.trustwave.baristamatic.service;

import java.math.BigDecimal;
import com.trustwave.baristamatic.enumtype.IngredientType;

public interface IngredientService {
	
	public int retrieveInventory(IngredientType ingredientType);
	public BigDecimal retrieveCost(IngredientType ingredientType);
}
