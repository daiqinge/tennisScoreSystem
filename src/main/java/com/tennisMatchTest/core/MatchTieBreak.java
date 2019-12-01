package com.tennisMatchTest.core;

import com.tennisMatchTest.bean.Player;

public class MatchTieBreak extends AbstractMatch{
//	public Player player1 = new Player("");
//	public Player player2 = new Player("");
//	
//    public MatchTieBreak(Player player1, Player player2) {
//    	this.player1 = player1;
//		this.player2 = player2;
//	}
//    
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
			return playerSet[0];
		}
		if(playerSet[1].getScore() >= GlobalVal.SEVEN_POINTS
				&&playerSet[1].getScore() - playerSet[0].getScore()>=GlobalVal.TWO_POINTS) {
			scoreSet[1]++;
			return playerSet[1];
		}
		return null;
	}

}
