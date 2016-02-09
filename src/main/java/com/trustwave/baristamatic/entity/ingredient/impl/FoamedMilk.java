package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;



public class FoamedMilk extends Ingredient {

	public FoamedMilk(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.FOAMED_MILK.getName();
	}
}
