package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Espresso extends Ingredient {
	
	public Espresso(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.ESPRESSO.getName();
	}

}
