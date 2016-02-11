package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Espresso extends Ingredient {
	
	public Espresso(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.ESPRESSO, price);
	}
}
