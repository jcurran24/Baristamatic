package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class BlackCoffee extends Ingredient {
	
	public BlackCoffee(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.COFFEE, price);
	}
}
