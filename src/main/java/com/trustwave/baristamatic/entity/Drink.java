package com.trustwave.baristamatic.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Drink {
	private int drinkId;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	private String name;
	
	public Drink(int drinkId, String name, Map<String, String> ingredientPriceMap, List<Integer> ingredientIds, Map<Integer, String> ingredientIdToIngredientMap) {
		this.drinkId = drinkId;
		this.name = name;
		
		for(Integer ingredientId : ingredientIds) {
			ingredients.add(new Ingredient(Integer.valueOf(ingredientId),  ingredientIdToIngredientMap.get(ingredientId), BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(ingredientIdToIngredientMap.get(ingredientId))))));
		}
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getDrinkId() {
		return drinkId;
	}

	public String getName() {
		return name;
	}
}
