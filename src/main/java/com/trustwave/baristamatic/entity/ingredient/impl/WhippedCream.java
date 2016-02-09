package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class WhippedCream extends Ingredient {

	public WhippedCream(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.WHIPPED_CREAM.getName();
	}
}
