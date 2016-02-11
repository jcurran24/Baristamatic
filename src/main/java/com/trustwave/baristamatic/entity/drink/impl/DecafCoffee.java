package com.trustwave.baristamatic.entity.drink.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.ingredient.factory.IngredientFactory;
import com.trustwave.baristamatic.enumtype.IngredientType;

public class DecafCoffee implements Drink {

	private int drinkId;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public DecafCoffee(int drinkId, Map<String, String> ingredientPriceMap) {
		this.drinkId = drinkId;
		ingredients.add(IngredientFactory.createIngredient(IngredientType.DECAF_COFFEE, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.DECAF_COFFEE.getName())))));
		ingredients.add(IngredientFactory.createIngredient(IngredientType.DECAF_COFFEE, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.DECAF_COFFEE.getName())))));
		ingredients.add(IngredientFactory.createIngredient(IngredientType.DECAF_COFFEE, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.DECAF_COFFEE.getName())))));
		ingredients.add(IngredientFactory.createIngredient(IngredientType.SUGAR, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.SUGAR.getName())))));
		ingredients.add(IngredientFactory.createIngredient(IngredientType.CREAM, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(IngredientType.CREAM.getName())))));
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getDrinkId() {
		return drinkId;
	}

	@Override
	public String getName() {
		return "Decaf Coffee";
	}
}
