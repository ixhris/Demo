package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SingleScope {
	
	private int count = 0;

	/**
	 * @return the count
	 */
	public int getCount() {
		return count ++;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
