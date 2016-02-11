package com.trustwave.baristamatic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;

import com.trustwave.baristamatic.entity.drink.util.DrinkCostUtil;
import com.trustwave.baristamatic.service.DrinkService;
import com.trustwave.baristamatic.service.IngredientService;

@Service
public class DrinkServiceImpl implements DrinkService {
	@Autowired
	private IngredientService ingredientService;
	
	@Value("#{drinkChoiceMap}")
	private Map<Integer, String> drinkChoiceMap;
	
	@Value("#{ingredientIdListingMap}")
	private Map<Integer, String> ingredientIdListingMap;
	
	@Value("#{drinkIdToIngredientIdsList}")
	private Map<Integer, List<Integer>> drinkIdToIngredientIdsList;
	
	private List<Drink> allDrinks = new ArrayList<Drink>();
	
	@PostConstruct
	public void initAllDrinks() {
		Map<String, String> ingredientPriceMap = ingredientService.getIngredientPriceMap();
		Set<Integer> drinkChoiceKeys = drinkChoiceMap.keySet();
		for(Integer drinkId : drinkChoiceKeys) {
			List<Integer> ingredientIds = drinkIdToIngredientIdsList.get(drinkId);
			allDrinks.add(new Drink(drinkId.intValue(), drinkChoiceMap.get(drinkId),  ingredientPriceMap, ingredientIds, ingredientIdListingMap));
		}
	}
	
	
	@Override
	public List<Drink> retrieveAllDrinks() {
		return allDrinks;
	}
	
	public boolean isInStock(Drink drink) {
		List<Ingredient> ingredients = drink.getIngredients();
		
		boolean isInStock = true;
		for(Ingredient ingredient : ingredients) {
			if(ingredientService.retrieveInventory(ingredient.getIngredientId()) < 1) {
				isInStock = false;
				break;
			}
		}
		return isInStock;
	}
	
	public void vendDrink(Drink drink) {
		for(Ingredient ingredient : drink.getIngredients()) {
			ingredientService.takeIngredient(ingredient.getIngredientId());
		}
	}
	
	public BigDecimal calculatedDrinkCost(Drink drink) {
		return DrinkCostUtil.calculateCost(drink.getIngredients());
	}
}
