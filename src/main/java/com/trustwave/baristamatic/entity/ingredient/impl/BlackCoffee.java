package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class BlackCoffee extends Ingredient {
	
	public BlackCoffee(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.COFFEE.getName();
	}
}
