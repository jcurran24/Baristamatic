package com.trustwave.baristamatic.entity.ingredient.impl;

import java.math.BigDecimal;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;



public class Cocoa extends Ingredient {

	public Cocoa(int ingredientId, BigDecimal price) {
		super(ingredientId, IngredientType.COCOA, price);
	}	
}
