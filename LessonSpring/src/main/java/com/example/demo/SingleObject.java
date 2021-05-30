package com.example.demo;

public class SingleObject {
	
	private static SingleObject singleObject;
	private static int count = 0;
	
	private SingleObject() {
		singleObject = null;
	}
	
	public static SingleObject getInstance() {
		if (singleObject==null) {
			return new SingleObject();
		}else {
			return singleObject;
		}
	}

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count ++;
	}

	/**
	 * @param count the count to set
	 */
	public static void setCount(int count) {
		SingleObject.count = count;
	}
	
	
	

}
