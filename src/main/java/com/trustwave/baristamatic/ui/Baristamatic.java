package com.trustwave.baristamatic.ui;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.trustwave.baristamatic.entity.Drink;
import com.trustwave.baristamatic.entity.Ingredient;
import com.trustwave.baristamatic.enumtype.IngredientType;
import com.trustwave.baristamatic.service.DrinkService;
import com.trustwave.baristamatic.service.IngredientService;

@Component
public class Baristamatic {
	
	public static void main(String...args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Baristamatic baristamatic = (Baristamatic)applicationContext.getBean(Baristamatic.class);
		
		System.out.println("Welcome to the Barista-matic\n");
		
		boolean isNotEnd = true;
		while(isNotEnd) {
			System.out.println("Inventory:");
		
			for (Ingredient ingredient :  baristamatic.ingredientService.retrieveAllIngredients() ) {
			  System.out.println(ingredient.getName() + "," + baristamatic.ingredientService.retrieveInventory(ingredient.getIngredientId()));
			}
		
			List<Drink> drinks = baristamatic.drinkService.retrieveAllDrinks();
		
			System.out.println("\nDrink Menu: ");
		
			int i = 1;
			for(Drink drink : drinks) {
				System.out.println(Integer.valueOf(i) + "," + drink.getName() + "," + NumberFormat.getCurrencyInstance().format(baristamatic.drinkService.calculatedDrinkCost(drink)) + "," 
						+ baristamatic.drinkService.isInStock(drink)); 
			}
		
		
			System.out.println("\nPlease select from the following options: ");
			System.out.println("* 'R' or 'r' - restock the inventory and redisplay the menu");
			System.out.println("* 'Q' or 'q' - quit the application");
			System.out.println("[1-" + drinks.size() + "] - order the drink with the corresponding number in the menu");
			
			int ch;
			try {
				if ((ch = System.in.read ()) != -1) {
				     switch(((char) ch)) {
				     	case 'R':
				     	case 'r':
				     		baristamatic.ingredientService.restockIngredients();
				     		break;
				     	case 'Q':
				     	case 'q':
				     		isNotEnd = false;
				     		break;
				     	case '1':
				     	case '2':
				     	case '3':
				     	case '4':
				     	case '5':
				     	case '6':
				     		isNotEnd = false;
				     		break;
				     }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private DrinkService drinkService;
}
