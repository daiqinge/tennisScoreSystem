package com.tennisMatchTest.api;

import com.tennisMatchTest.bean.Player;

/**
 * A interface that calculate score.
 */
public interface MatchI {
	 /**
     * the player who gets score this time, add score to the previous score
     *
     * @param name  player name
     */
	public void pointWonBy(String name);
	
	 /**
     * scores description of two players
     */
	public String score();
	
	 /**
     * true or false, if the situation is TieBreak
     */
	public boolean isTieBreak();
	
	 /**
     * if one player wins
     */
	public Player winner();
	
}
