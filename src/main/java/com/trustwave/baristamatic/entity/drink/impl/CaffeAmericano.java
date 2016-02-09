package com.trustwave.baristamatic.entity.drink.impl;

import java.util.ArrayList;
import java.util.List;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.ingredient.impl.Espresso;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class CaffeAmericano implements Drink {

	private int drinkId;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public CaffeAmericano(int drinkId) {
		this.drinkId = drinkId;
		ingredients.add(new Espresso(IngredientType.ESPRESSO.getIngredientId()));
		ingredients.add(new Espresso(IngredientType.ESPRESSO.getIngredientId()));
		ingredients.add(new Espresso(IngredientType.ESPRESSO.getIngredientId()));
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getDrinkId() {
		return drinkId;
	}
}
