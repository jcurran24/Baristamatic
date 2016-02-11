package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Cream extends Ingredient {
	public Cream(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.CREAM, price);
	}
}
