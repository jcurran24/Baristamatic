package com.trustwave.baristamatic.entity;

import java.math.BigDecimal;


public class Ingredient {
	protected int ingredientId;
	protected BigDecimal price;
	protected String name;
	
	public Ingredient(int ingredientId, String name, BigDecimal price) {
		this.ingredientId = ingredientId;
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
}
