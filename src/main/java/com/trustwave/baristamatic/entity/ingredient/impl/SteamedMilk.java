package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class SteamedMilk extends Ingredient {

	public SteamedMilk(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.STEAMED_MILK.getName();
	}
	
}
