package com.tennisMatchTest.core;

import com.tennisMatchTest.api.MatchI;
import com.tennisMatchTest.bean.Player;

public class Match extends AbstractMatch{
	private MatchI matchI = new MatchPoint();
	
	public Match(Player player1, Player player2) {
		playerSet[0] = player1;
		playerSet[1] = player2;
	}

	public void pointWonBy(String name) {
		//case1: at stage of tie break, go deuce
		if(matchI.isTieBreak()) {
			matchI = new MatchDeuce();
			return;
		}
		int index = getPlayerIndexByName(name);
		playerSet[index].setScore(playerSet[index].getScore() + 1);
		
		//case2: no one win, add point, go tie break or point
		Player winner = matchI.winner();
		if(winner == null) {
			
			if(playerSet[0].getScore() == GlobalVal.SIX_POINTS
					&& playerSet[1].getScore() == GlobalVal.SIX_POINTS) {
				matchI = new MatchTieBreak();
			}else if(Math.abs(playerSet[0].getScore() - playerSet[1].getScore()) <= GlobalVal.ONE_POINT
					&& playerSet[0].getScore() >= GlobalVal.THREE_POINTS
					&& playerSet[1].getScore() >= GlobalVal.THREE_POINTS) {
				matchI = new MatchDeuce();
			}else{
				matchI = new MatchPoint();
			}
		}
	}

	public String score() {
		String scoreGame = matchI.score().equals("")? "": ", " + matchI.score();
		return scoreSet[0] + "-" + scoreSet[1] + scoreGame;
	}

	public boolean isTieBreak() {
		return false;
	}

	/**
	 * case1: 7 points after tiebreak; 
	 * case2: 6 points && 2 points higher; 
	 * case2: 4 points && 2 points higher;
	 * win
	 */
	public Player winner() {
		//
		int index = getLeadPlayerIndex();
	    Player leadPlayer = playerSet[index];
		if ((leadPlayer.getScore() >= GlobalVal.FOUR_POINTS 
				&& Math.abs(playerSet[1].getScore() - playerSet[0].getScore()) >= GlobalVal.TWO_POINTS)
				|| leadPlayer.getScore() == GlobalVal.SEVEN_POINTS
				|| (leadPlayer.getScore() == GlobalVal.SIX_POINTS 
				&& Math.abs(playerSet[1].getScore() - playerSet[0].getScore()) >= GlobalVal.TWO_POINTS)) {
			scoreSet[index]++;
			return playerSet[index];
		}
			
		return null;
	}

	private int getPlayerIndexByName(String name) {
		return playerSet[0].getName().equals(name)? 0 : 1;
	}

}
