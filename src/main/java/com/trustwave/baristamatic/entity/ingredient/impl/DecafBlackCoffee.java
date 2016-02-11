package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class DecafBlackCoffee extends Ingredient {
	
	public DecafBlackCoffee(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.DECAF_COFFEE, price);
	}
}
