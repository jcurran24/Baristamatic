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

}
