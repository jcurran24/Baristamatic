package com.trustwave.baristamatic.enumtype;

public enum IngredientType{
	COFFEE("Coffee", 1), DECAF_COFFEE("Decaf Coffee", 2), SUGAR("Sugar", 3), 
	CREAM("Cream", 4), ESPRESSO("Espresso", 5), COCOA("Cocoa", 6), STEAMED_MILK("Steamed Milk", 7),
	WHIPPED_CREAM("Whipped Cream", 8), FOAMED_MILK("Foamed Milk", 9);
	
	private String name;
	private int ingredientId;
	
	private IngredientType(String name, int ingredientId) {
		this.name = name;
		this.ingredientId = ingredientId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIngredientId() {
		return ingredientId;
	}
}