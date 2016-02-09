package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Cream extends Ingredient {
	public Cream(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.CREAM.getName();
	}
}
