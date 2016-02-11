package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class SteamedMilk extends Ingredient {

	public SteamedMilk(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.STEAMED_MILK, price);
	}
}
