package com.trustwave.baristamatic.entity.ingredient.impl;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;



public class Cocoa extends Ingredient {

	public Cocoa(int ingredientId) {
		super(ingredientId);
	}

	public String getName() {
		return IngredientType.COCOA.getName();
	}
	
}
