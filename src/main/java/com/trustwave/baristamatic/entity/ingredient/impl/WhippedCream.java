package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class WhippedCream extends Ingredient {

	public WhippedCream(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.WHIPPED_CREAM, price);
	}
}
