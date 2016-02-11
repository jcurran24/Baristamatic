package com.trustwave.baristamatic.entity;

import java.math.BigDecimal;

import com.trustwave.baristamatic.enumtype.IngredientType;

public abstract class Ingredient {
	protected int ingredientId;
	protected BigDecimal price;
	protected IngredientType ingredientType;
	
	public Ingredient(int ingredientId, IngredientType ingredientType, BigDecimal price) {
		this.ingredientId = ingredientId;
		this.ingredientType = ingredientType;
		this.price = price;
	}
	
	public String getName() {
		return ingredientType.getName();
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
	
	/**
	 * @return the ingredientType
	 */
	public IngredientType getIngredientType() {
		return ingredientType;
	}

	/**
	 * @param ingredientType the ingredientType to set
	 */
	public void setIngredientType(IngredientType ingredientType) {
		this.ingredientType = ingredientType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
		result = prime * result
				+ ((ingredientType == null) ? 0 : ingredientType.hashCode());
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
		if (ingredientType != other.ingredientType)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	
}
