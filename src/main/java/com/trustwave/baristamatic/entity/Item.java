package com.trustwave.baristamatic.entity;

import java.util.List;

public interface Item {

	public Long getItemId();
	public String getName();
	public String getDescription();
	public List<Ingredient> getIngredients();
	
	public Long getPriceId();
	
}
