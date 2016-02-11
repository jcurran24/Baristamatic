package com.trustwave.baristamatic.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trustwave.baristamatic.enumtype.IngredientType;
import com.trustwave.baristamatic.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Value("#{ingredientCountMap}")
	private Map<String, String> ingredientCountMap;
	
	@Value("#{ingredientPriceMap}")
	private Map<String, String> ingredientPriceMap;
	
	
	@Override
	public int retrieveInventory(IngredientType ingredientType) {
		return Integer.valueOf(ingredientCountMap.get(ingredientType.getName()));
	}
	
	
	@Override
	public BigDecimal retrieveCost(IngredientType ingredientType) {
		return BigDecimal.valueOf(Double.valueOf(ingredientPriceMap.get(ingredientType.getIngredientId())));
	}
	
	public Map<String, String> getIngredientPriceMap() {
		return ingredientPriceMap;
	}
	
	
	public void restockIngredients() {
		ingredientCountMap.put("Coffee", "10");
		ingredientCountMap.put("Decaf Coffee", "10");
		ingredientCountMap.put("Sugar", "10");
		ingredientCountMap.put("Cream", "10");
		ingredientCountMap.put("Espresso", "10");
		ingredientCountMap.put("Steamed Milk", "10");
		ingredientCountMap.put("Cocoa", "10");
		ingredientCountMap.put("Whipped Cream", "10");
		ingredientCountMap.put("Foamed Milk", "10");
	}

}
