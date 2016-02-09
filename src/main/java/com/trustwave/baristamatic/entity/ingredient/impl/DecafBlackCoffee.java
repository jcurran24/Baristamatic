package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class DecafBlackCoffee extends Ingredient {
	
	public DecafBlackCoffee(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.DECAF_COFFEE.getName();
	}
}
