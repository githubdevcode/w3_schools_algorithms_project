package com.dsa.algorithms.tree.dto;

import java.util.Objects;

public class DishRate implements Comparable<DishRate>{
	private int number;
	private int rate;
	
	public DishRate(Integer number, Integer rate) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.rate = rate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public int compareTo(DishRate o) {
		// TODO Auto-generated method stub
		int result = 0;
		if(this.getRate() > o.getRate()) {
			result = 1;			
		} else if(this.getRate() == o.getRate()) {
			if(this.getNumber() < o.getNumber()) {
				result = 1;
			} if(this.getNumber() > o.getNumber()) {
				result = -1;
			}
		} else if(this.getRate() < o.getRate()) {
			result = -1;
		} 
		
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DishRate other = (DishRate) obj;
		return number == other.number;
	}

}
