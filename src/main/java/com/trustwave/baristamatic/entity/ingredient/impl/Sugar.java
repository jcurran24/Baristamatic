package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Sugar extends Ingredient {
	
	public Sugar(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.SUGAR, price);
	}
}
