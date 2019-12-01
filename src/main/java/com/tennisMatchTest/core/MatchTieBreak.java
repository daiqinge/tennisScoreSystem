package com.tennisMatchTest.core;

import com.tennisMatchTest.bean.Player;

public class MatchTieBreak extends AbstractMatch{

	public String score() {
		if (playerSet[0].getScore() == GlobalVal.ZERO_POINT 
				&& playerSet[1].getScore() == GlobalVal.ZERO_POINT) {
			return "";
		}
		return playerSet[0].getScore() + "-" + playerSet[1].getScore();
	}

	public boolean isTieBreak() {
		return false;
	}

	public Player winner() {
		if(playerSet[0].getScore() >= GlobalVal.SEVEN_POINTS
				&&playerSet[0].getScore() - playerSet[1].getScore()>=GlobalVal.TWO_POINTS) {
			scoreSet[0]++;
			playerSet[0].setScore(0);
			playerSet[1].setScore(0);
			return playerSet[0];
		}
		if(playerSet[1].getScore() >= GlobalVal.SEVEN_POINTS
				&&playerSet[1].getScore() - playerSet[0].getScore()>=GlobalVal.TWO_POINTS) {
			scoreSet[1]++;
			playerSet[0].setScore(0);
			playerSet[1].setScore(0);
			return playerSet[1];
		}
		return null;
	}

}
