package com.trustwave.baristamatic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.drink.impl.CaffeAmericano;
import com.trustwave.baristamatic.entity.drink.impl.CaffeLatte;
import com.trustwave.baristamatic.entity.drink.impl.CaffeMocha;
import com.trustwave.baristamatic.entity.drink.impl.Cappuccino;
import com.trustwave.baristamatic.entity.drink.impl.Coffee;
import com.trustwave.baristamatic.entity.drink.impl.DecafCoffee;
import com.trustwave.baristamatic.entity.drink.util.DrinkCostUtil;
import com.trustwave.baristamatic.service.DrinkService;
import com.trustwave.baristamatic.service.IngredientService;

@Service
public class DrinkServiceImpl implements DrinkService {
	@Autowired
	private IngredientService ingredientService;
	
	private List<Drink> allDrinks = new ArrayList<Drink>();
	
	@PostConstruct
	public void initAllDrinks() {
		Map<String, String> ingredientPriceMap = ingredientService.getIngredientPriceMap();
		allDrinks.add(new Coffee(1,  ingredientPriceMap));
		allDrinks.add(new DecafCoffee(2, ingredientPriceMap));
		allDrinks.add(new CaffeLatte(3, ingredientPriceMap));
		allDrinks.add(new CaffeAmericano(4, ingredientPriceMap));
		allDrinks.add(new CaffeMocha(5, ingredientPriceMap));
		allDrinks.add(new Cappuccino(6, ingredientPriceMap));
	}
	
	@Override
	public List<Drink> retrieveAllDrinks() {
		return allDrinks;
	}
	
	public boolean isInStock(Drink drink) {
		List<Ingredient> ingredients = drink.getIngredients();
		
		boolean isInStock = true;
		for(Ingredient ingredient : ingredients) {
			if(ingredientService.retrieveInventory(ingredient.getIngredientType()) < 1) {
				isInStock = false;
				break;
			}
		}
		return isInStock;
	}
	
	public BigDecimal calculatedDrinkCost(Drink drink) {
		return DrinkCostUtil.calculateCost(drink.getIngredients());
	}
}
