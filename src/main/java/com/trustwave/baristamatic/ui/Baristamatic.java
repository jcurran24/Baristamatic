package com.trustwave.baristamatic.ui;

import java.text.NumberFormat;
import java.util.List;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.enumtype.IngredientType;
import com.trustwave.baristamatic.service.DrinkService;
import com.trustwave.baristamatic.service.IngredientService;

@Component
public class Baristamatic {
	
	public static void main(String...args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Baristamatic baristamatic = (Baristamatic)applicationContext.getBean(Baristamatic.class);
		
		System.out.println("Welcome to the Barista-matic\n");
		System.out.println("Below are the following current inventory of drink ingredients available:");
		
		for (IngredientType ingredientType : IngredientType.values()) {
			  System.out.println(ingredientType.getName() + ": " + baristamatic.ingredientService.retrieveInventory(ingredientType));
		}
		
		List<Drink> drinks = baristamatic.drinkService.retrieveAllDrinks();
		
		System.out.println("\nDrink Menu: ");
		
		for(Drink drink : drinks) {
			System.out.println(drink.getName() + ": " + NumberFormat.getCurrencyInstance().format(baristamatic.drinkService.calculatedDrinkCost(drink))); 
		}	
	}
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private DrinkService drinkService;
}
