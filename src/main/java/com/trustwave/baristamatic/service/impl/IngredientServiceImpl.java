package com.trustwave.baristamatic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Value("#{ingredientIdListingMap}")
	private Map<Integer, String> ingredientIdListingMap;
	
	@Value("#{ingredientCountMap}")
	private Map<String, Integer> ingredientCountMap;
	
	@Value("#{ingredientPriceMap}")
	private Map<String, String> ingredientPriceMap;
	
	
	@Override
	public int retrieveInventory(int ingredientId) {
		return ingredientCountMap.get(ingredientIdListingMap.get(ingredientId));
	}
	
	public List<Ingredient> retrieveAllIngredients() {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Set<Integer> keySet = ingredientIdListingMap.keySet();
		for(Integer ingredientId : keySet) {
			Ingredient ingredient = new Ingredient(ingredientId, ingredientIdListingMap.get(ingredientId), BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(ingredientIdListingMap.get(ingredientId)))));
			ingredients.add(ingredient);
		}
		return ingredients;
	}
	
	
	@Override
	public BigDecimal retrieveCost(int ingredientId) {
		return BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(ingredientIdListingMap.get(ingredientId))));
	}
	
	public Map<String, String> getIngredientPriceMap() {
		return ingredientPriceMap;
	}
	
	public Ingredient takeIngredient(int ingredientId) {
		 Integer ingredientCount = Integer.valueOf(ingredientCountMap.get(ingredientIdListingMap.get(ingredientId)));
		 ingredientCount--;
		 ingredientCountMap.put(ingredientIdListingMap.get(ingredientId), ingredientCount);
		 
		 return new Ingredient(ingredientId, ingredientIdListingMap.get(ingredientId), BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(ingredientIdListingMap.get(ingredientId)))));
		 //return IngredientFactory.createIngredient(ingredientType, BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(ingredientIdListingMap.get(ingredientId)))));
	}
	
	
	public void restockIngredients() {
		Set<String> keySet = ingredientCountMap.keySet();
		
		for(String ingredientName : keySet) {
			ingredientCountMap.put(ingredientName, 10);
		}
	}

}
