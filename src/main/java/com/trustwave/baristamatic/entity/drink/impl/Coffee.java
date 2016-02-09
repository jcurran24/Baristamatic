package com.trustwave.baristamatic.entity.drink.impl;

import java.util.ArrayList;
import java.util.List;


import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.ingredient.impl.BlackCoffee;
import com.trustwave.baristamatic.entity.ingredient.impl.Cream;
import com.trustwave.baristamatic.entity.ingredient.impl.Sugar;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class Coffee implements Drink {
	private int drinkId;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Coffee(int drinkId) {
		this.drinkId = drinkId;
		ingredients.add(new BlackCoffee(IngredientType.COFFEE.getIngredientId()));
		ingredients.add(new BlackCoffee(IngredientType.COFFEE.getIngredientId()));
		ingredients.add(new BlackCoffee(IngredientType.COFFEE.getIngredientId()));
		ingredients.add(new Sugar(IngredientType.SUGAR.getIngredientId()));
		ingredients.add(new Cream(IngredientType.CREAM.getIngredientId()));
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getDrinkId() {
		return drinkId;
	}

}
