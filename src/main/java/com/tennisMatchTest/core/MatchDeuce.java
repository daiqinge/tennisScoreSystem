package com.tennisMatchTest.core;

import com.tennisMatchTest.bean.Player;

public class MatchDeuce extends AbstractMatch{
    
	public String score() {
		if (playerSet[0].getScore() == GlobalVal.ZERO_POINT
				&& playerSet[1].getScore() == GlobalVal.ZERO_POINT)
			return "";
		if (playerSet[0].getScore() == playerSet[1].getScore()) return GlobalVal.DEUCE;
		int index = getLeadPlayerIndex();
		return GlobalVal.ADVANTAGE + " " + playerSet[index].getName();
	}

	public boolean isTieBreak() {
		return false;
	}

	public Player winner() {
		int player1Score = playerSet[0].getScore();
		int player2Score = playerSet[1].getScore();
		if (player1Score - player2Score == GlobalVal.TWO_POINTS) {
			scoreSet[0]++;
			playerSet[0].setScore(0);
			playerSet[1].setScore(0);
			return playerSet[0];
		}
		if (player2Score - player1Score == GlobalVal.TWO_POINTS) {
			scoreSet[1]++;
			playerSet[0].setScore(0);
			playerSet[1].setScore(0);
			return playerSet[1];
		}
		return null;
	}

}
