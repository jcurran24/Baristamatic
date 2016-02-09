package com.trustwave.baristamatic.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.trustwave.baristamatic.enumtype.IngredientType;
import com.trustwave.baristamatic.service.IngredientService;

@Component
public class Baristamatic {
	
	@Autowired
	private IngredientService ingredientService;
	
	public static void main(String...args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Baristamatic baristamatic = (Baristamatic)applicationContext.getBean(Baristamatic.class);
		
		System.out.println(baristamatic.ingredientService.retrieveInventory(IngredientType.COFFEE));
		

	}
	
}
