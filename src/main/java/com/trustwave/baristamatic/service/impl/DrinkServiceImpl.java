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
		List<Integer> sortedDrinkChoiceKeys = new ArrayList();
		sortedDrinkChoiceKeys.addAll(drinkChoiceKeys);
		java.util.Collections.sort(sortedDrinkChoiceKeys);
		
		for(Integer drinkId : sortedDrinkChoiceKeys) {
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
		
		Set<Integer> ingredientIds = ingredientIdListingMap.keySet();
		
		Integer[] ingredientIdCounts = new Integer[ingredientIds.size()];
		for(int i = 0; i < ingredientIdCounts.length; i++){
			ingredientIdCounts[i] = 0;
		}
		
		for(Ingredient ingredient : ingredients) {
			if((ingredientService.retrieveInventory(ingredient.getIngredientId()) - ingredientIdCounts[ingredient.getIngredientId()-1]) < 1) {
				isInStock = false;
				break;
			}
			ingredientIdCounts[ingredient.getIngredientId()-1]++;
		}
		return isInStock;
	}
	
	public Drink vendDrink(int drinkChoice) {
		String drinkName = drinkChoiceMap.get(Integer.valueOf(String.valueOf((char)drinkChoice)));
		List<Integer> ingredientIds = drinkIdToIngredientIdsList.get(Integer.valueOf(String.valueOf((char)drinkChoice)));
		
		Map<String, String> ingredientPriceMap = ingredientService.getIngredientPriceMap();
		Drink drinkToBeVended = new Drink(drinkChoice, drinkName,  ingredientPriceMap, ingredientIds, ingredientIdListingMap);
		
		if(!isInStock(drinkToBeVended)) {
			drinkToBeVended.setInStock(false);
		} else {
			drinkToBeVended.setInStock(true);
		}
		
		for(Integer ingredientId : ingredientIds) {
			ingredientService.takeIngredient(ingredientId);
		}
		return drinkToBeVended;
	}
	
	public BigDecimal calculatedDrinkCost(Drink drink) {
		return DrinkCostUtil.calculateCost(drink.getIngredients());
	}
	
	public boolean isDrinkChoice(char choice) {
		if(Character.isLetter(choice)) {
			return false;
		}
		
		if(Character.isDigit(choice)) {
			Set<Integer> drinkChoiceNumbers = drinkChoiceMap.keySet();
			
			if(drinkChoiceNumbers.contains(Integer.valueOf(String.valueOf(choice)))) {
				return true;
			}
		}
		return false;
	}
}
