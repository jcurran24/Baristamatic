package com.trustwave.baristamatic.entity;

import java.math.BigDecimal;

public abstract class Ingredient {
	protected int ingredientId;
	protected BigDecimal price;
	
	public Ingredient(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public abstract String getName();
	
	public int getIngredientId() {
		return ingredientId;
	}
	
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	public BigDecimal getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId)
			return false;
		return true;
	}
}
