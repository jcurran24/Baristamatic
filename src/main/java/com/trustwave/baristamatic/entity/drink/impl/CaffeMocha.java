package com.trustwave.baristamatic.entity.drink.impl;

import java.util.ArrayList;
import java.util.List;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.ingredient.impl.Cocoa;
import com.trustwave.baristamatic.entity.ingredient.impl.Espresso;
import com.trustwave.baristamatic.entity.ingredient.impl.SteamedMilk;
import com.trustwave.baristamatic.entity.ingredient.impl.WhippedCream;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class CaffeMocha implements Drink {

	private int drinkId;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public CaffeMocha(int drinkId) {
		this.drinkId = drinkId;
		ingredients.add(new Espresso(IngredientType.ESPRESSO.getIngredientId()));
		ingredients.add(new Cocoa(IngredientType.COCOA.getIngredientId()));
		ingredients.add(new SteamedMilk(IngredientType.STEAMED_MILK.getIngredientId()));
		ingredients.add(new WhippedCream(IngredientType.WHIPPED_CREAM.getIngredientId()));
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getDrinkId() {
		return drinkId;
	}

}
