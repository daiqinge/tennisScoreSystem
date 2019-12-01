package com.tennisMatchTest.core;

import com.tennisMatchTest.bean.Player;

public class MatchPoint extends AbstractMatch{

	public String score() {
    	if (playerSet[0].getScore() == GlobalVal.ZERO_POINT 
    			&& playerSet[1].getScore() == GlobalVal.ZERO_POINT) {
    		return "";
    	}
    	return GlobalVal.scoreConvertMap.get(playerSet[0].getScore()) + "-" + GlobalVal.scoreConvertMap.get(playerSet[1].getScore());
    }

	public boolean isTieBreak() {
		if(playerSet[0].getScore() == GlobalVal.THREE_POINTS 
    			&& playerSet[1].getScore() == GlobalVal.THREE_POINTS) {
    		return true;
		}
    	return false;
	}

	public Player winner() {
		if(playerSet[0].getScore() == GlobalVal.FOUR_POINTS) {
			scoreSet[0]++;
			playerSet[0].setScore(0);
			playerSet[1].setScore(0);
			return playerSet[0];
		}
		if(playerSet[1].getScore() == GlobalVal.FOUR_POINTS) {
			scoreSet[1]++;
			playerSet[0].setScore(0);
			playerSet[1].setScore(0);
			return playerSet[1];
		}
		return null;
	}

}
