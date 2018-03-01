package com.projectimagesgame;

public class Box {
	
	private int value = 0;
	private boolean situation = false;

	public Box(int value, boolean situation) {
		this.value = value;
		this.situation = situation;
	}
	
	public int getValue() {
		return this.value;
	}

	public boolean getSituation() {
		return this.situation;
	}
	
	public void setSituation(boolean situation) {
		this.situation = situation;
	}
	
}
