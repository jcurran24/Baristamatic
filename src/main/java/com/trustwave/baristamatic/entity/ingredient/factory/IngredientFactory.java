package com.trustwave.baristamatic.entity.ingredient.factory;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.entity.drink.impl.Coffee;
import com.trustwave.baristamatic.entity.ingredient.impl.BlackCoffee;
import com.trustwave.baristamatic.entity.ingredient.impl.Cocoa;
import com.trustwave.baristamatic.entity.ingredient.impl.Cream;
import com.trustwave.baristamatic.entity.ingredient.impl.DecafBlackCoffee;
import com.trustwave.baristamatic.entity.ingredient.impl.Espresso;
import com.trustwave.baristamatic.entity.ingredient.impl.FoamedMilk;
import com.trustwave.baristamatic.entity.ingredient.impl.SteamedMilk;
import com.trustwave.baristamatic.entity.ingredient.impl.Sugar;
import com.trustwave.baristamatic.entity.ingredient.impl.WhippedCream;
import com.trustwave.baristamatic.enumtype.IngredientType;
import com.trustwave.baristamatic.service.IngredientService;

public class IngredientFactory {
	
	public static Ingredient createIngredient(IngredientType ingredientType, BigDecimal ingredientCost) {
		if(ingredientType.equals(IngredientType.COFFEE)) {
			return new BlackCoffee(IngredientType.COFFEE.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.DECAF_COFFEE)) {
			return new DecafBlackCoffee(IngredientType.DECAF_COFFEE.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.SUGAR)) {
			return new Sugar(IngredientType.SUGAR.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.CREAM)) {
			return new Cream(IngredientType.CREAM.getIngredientId(), ingredientCost);
		} else  if(ingredientType.equals(IngredientType.ESPRESSO)) {
			return new Espresso(IngredientType.ESPRESSO.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.COCOA)) {
			return new Cocoa(IngredientType.COCOA.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.STEAMED_MILK)) {
			return new SteamedMilk(IngredientType.STEAMED_MILK.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.FOAMED_MILK)) {
			return new FoamedMilk(IngredientType.FOAMED_MILK.getIngredientId(), ingredientCost);
		} else if(ingredientType.equals(IngredientType.WHIPPED_CREAM)) {
			return new WhippedCream(IngredientType.WHIPPED_CREAM.getIngredientId(), ingredientCost);
		} else {
			throw new IllegalArgumentException("Unknown ingredient type");
		}
	}
	
}
