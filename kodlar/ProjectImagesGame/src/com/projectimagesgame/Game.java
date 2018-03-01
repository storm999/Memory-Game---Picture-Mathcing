package com.projectimagesgame;

import java.util.Random;

public class Game {

    private Box[] boxes = new Box[16];
    private int score = 0;
    private Random random = new Random();
	
    public Game() {
        startGame();
    }
	
	public void startGame() {
		for (int i = 0; i < boxes.length; i+=2) {
			boxes[i] = new Box(i, false);
			boxes[i + 1] = new Box(i, false);
		}
		mixBoxes();
	}
	
	public void mixBoxes() {
		int temp1, temp2;
		Box tempBox;
		for (int i = 0; i < boxes.length; i++) {
			temp1 = random.nextInt(boxes.length);
			temp2 = random.nextInt(boxes.length);
			tempBox = boxes[temp1];
			boxes[temp1] = boxes[temp2];
			boxes[temp2] = tempBox;
		}
	}
	
	public void gameScore(boolean scoreSituation) {
		if (scoreSituation == false) {
			score -= 1;
		}
		else if (scoreSituation == true) {
			score += 10;
		}
		if(score < 0) {
			score = 0;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean isEnd() {
		int count = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].getSituation()) {
				count +=1;
			}
		}
		if(count == boxes.length) {
			return true;
		}
		return false;
	}
	
	public void resetGame() {
		startGame();
		score = 0;
	}
	
	public boolean checkMatched(int index1, int index2) {
		if (!boxes[index1].getSituation() && !boxes[index1].getSituation()) {
			if (boxes[index1].getValue() == boxes[index2].getValue()) {
				boxes[index1].setSituation(true);
				boxes[index2].setSituation(true);
				return true;
			}
		}
		return false;
	}
	
	public int getValueOfBox(int boxId) {
		return boxes[boxId].getValue();
	}
	
	public boolean getSituationOfBox(int boxId) {
		return boxes[boxId].getSituation();
	}
	
}
