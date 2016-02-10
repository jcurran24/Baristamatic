package com.trustwave.baristamatic.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.trustwave.baristamatic.enumtype.IngredientType;
import com.trustwave.baristamatic.service.IngredientService;

@Component
public class Baristamatic {
	
	public static void main(String...args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Baristamatic baristamatic = (Baristamatic)applicationContext.getBean(Baristamatic.class);
		
		System.out.println("Welcome to the Barista-matic\n");
		System.out.println("Below are the following current inventory of drink ingredients available:");
		
		System.out.println(IngredientType.COFFEE.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.COFFEE));
		System.out.println(IngredientType.DECAF_COFFEE.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.DECAF_COFFEE));
		System.out.println(IngredientType.CREAM.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.CREAM));
		System.out.println(IngredientType.ESPRESSO.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.ESPRESSO));
		System.out.println(IngredientType.SUGAR.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.SUGAR));
		System.out.println(IngredientType.COCOA.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.COCOA));
		System.out.println(IngredientType.STEAMED_MILK.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.STEAMED_MILK));
		System.out.println(IngredientType.FOAMED_MILK.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.FOAMED_MILK));
		System.out.println(IngredientType.WHIPPED_CREAM.getName() + ": " +  baristamatic.ingredientService.retrieveInventory(IngredientType.WHIPPED_CREAM));
	}
	
	@Autowired
	private IngredientService ingredientService;
}
