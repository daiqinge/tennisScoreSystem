package com.tennisMatchTest.core;

import com.tennisMatchTest.api.MatchI;
import com.tennisMatchTest.bean.Player;

public abstract class AbstractMatch implements MatchI{
	protected static Player[] playerSet = {new Player(""), new Player("")};
	protected static  int[] scoreSet = new int[2];
	
	public void pointWonBy(String name) {
		if(playerSet[0].getName().equals(name)) {
			playerSet[0].setScore(playerSet[0].getScore() + 1);
			return;
		}
		playerSet[1].setScore(playerSet[1].getScore() + 1);
	}
	
	protected int getLeadPlayerIndex() {
		return (playerSet[0].getScore() > playerSet[1].getScore()) ? GlobalVal.PLAYER1_INDEX  : GlobalVal.PLAYER2_INDEX ;
	}
	
	public abstract String score();
	public abstract boolean isTieBreak();
  
}
