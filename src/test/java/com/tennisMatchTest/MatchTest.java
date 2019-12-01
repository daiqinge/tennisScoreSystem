package com.tennisMatchTest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.tennisMatchTest.api.MatchI;
import com.tennisMatchTest.bean.Player;
import com.tennisMatchTest.core.Match;

public class MatchTest {
	private static final Player PLAYER1 = new Player("player 1");
	private static final Player PLAYER2 = new Player("player 2");
	private MatchI match;

	@Before
	public void beforeGameTest() {
		match = new Match(PLAYER1, PLAYER2);
	}

//	@Test
//	public void test_pointWon() {
//		match.pointWonBy(PLAYER1.getName());
//		match.pointWonBy(PLAYER2.getName());
//	}
//
	@Test
	public void test_deuceWinscore() {
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER2.getName());
		assertEquals("0-0, 15-15", match.score());
		
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER1.getName());
		assertEquals("0-0, 40-15", match.score());
		
		match.pointWonBy(PLAYER2.getName());
		match.pointWonBy(PLAYER2.getName());
		assertEquals("0-0, Deuce", match.score());
		
		match.pointWonBy(PLAYER1.getName());
		assertEquals("0-0, Advantage player 1", match.score());
		
		match.pointWonBy(PLAYER1.getName());
		assertEquals("1-0", match.score());
	}
	
	@Test
	public void test_tieBreakWinscore() {
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER2.getName());
		assertEquals("0-0, 15-15", match.score());
		
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER2.getName());
		assertEquals("0-0, 30-30", match.score());
		
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER2.getName());
		assertEquals("0-0, Deuce", match.score());
		
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER2.getName());
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER2.getName());
		match.pointWonBy(PLAYER1.getName());
		assertEquals(false, match.isTieBreak());
		
		match.pointWonBy(PLAYER1.getName());
		assertEquals("1-0", match.score()); //7-5
	}

}