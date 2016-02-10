package com.trustwave.baristamatic.entity.drink.util;

import java.math.BigDecimal;
import java.util.List;

import com.trustwave.baristamatic.entity.Ingredient;

public class DrinkCostUtil {

	public static BigDecimal calculateCost(List<Ingredient> ingredients) {
		BigDecimal costSum = new BigDecimal(0);
		
		for(Ingredient ingredient : ingredients) {
			costSum = costSum.add(ingredient.getPrice());
		}
		return costSum;
	}
	
}
