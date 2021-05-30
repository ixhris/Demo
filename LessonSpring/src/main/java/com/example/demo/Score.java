package com.example.demo;

public class Score {
	
	private int period;
	private int math;
	private int eng;
	private int phy;
	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}
	/**
	 * @return the math
	 */
	public int getMath() {
		return math;
	}
	/**
	 * @param math the math to set
	 */
	public void setMath(int math) {
		this.math = math;
	}
	/**
	 * @return the eng
	 */
	public int getEng() {
		return eng;
	}
	/**
	 * @param eng the eng to set
	 */
	public void setEng(int eng) {
		this.eng = eng;
	}
	/**
	 * @return the phy
	 */
	public int getPhy() {
		return phy;
	}
	/**
	 * @param phy the phy to set
	 */
	public void setPhy(int phy) {
		this.phy = phy;
	}
	@Override
	public String toString() {
		return "Score [period=" + period + ", math=" + math + ", eng=" + eng + ", phy=" + phy + "]";
	}
	
	

}
