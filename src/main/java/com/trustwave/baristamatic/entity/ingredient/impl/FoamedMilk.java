package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;



public class FoamedMilk extends Ingredient {

	public FoamedMilk(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.FOAMED_MILK, price);
	}
}
