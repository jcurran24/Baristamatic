package com.trustwave.baristamatic.entity.drink.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.ingredient.factory.IngredientFactory;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class CaffeLatte implements Drink {

	private int drinkId;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public CaffeLatte(int drinkId, Map<String, String> ingredientPriceMap) {
		this.drinkId = drinkId;
		ingredients.add(IngredientFactory.createIngredient(IngredientType.ESPRESSO, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.ESPRESSO.getName())))));
		ingredients.add(IngredientFactory.createIngredient(IngredientType.ESPRESSO, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.ESPRESSO.getName())))));
		ingredients.add(IngredientFactory.createIngredient(IngredientType.STEAMED_MILK, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.STEAMED_MILK.getName())))));
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getDrinkId() {
		return drinkId;
	}

	@Override
	public String getName() {
		return "Caffe Latte";
	}
}
