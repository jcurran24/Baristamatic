package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Sugar extends Ingredient {
	
	public Sugar(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.SUGAR.getName();
	}
	
}
