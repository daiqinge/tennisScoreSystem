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
	
	@Test
	public void test_zeroWon() {
		assertEquals("0-0", match.score());
	}

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
		match.pointWonBy(PLAYER2.getName());
		match.pointWonBy(PLAYER1.getName());
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
	
	@Test
	public void test_tieBreakSIXSIXWinscore() {
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
		match.pointWonBy(PLAYER2.getName());
		assertEquals(true, match.isTieBreak());//6-6
		
		match.pointWonBy(PLAYER1.getName());
		match.pointWonBy(PLAYER1.getName());
		assertEquals("1-0", match.score()); 
	}
	
	@Test
	public void test_Player1Winscore() {
		for(int i =0 ; i < 4; i++) {
			match.pointWonBy(PLAYER1.getName());
		}
		assertEquals("1-0", match.score()); 
		
		match.pointWonBy(PLAYER1.getName());
		assertEquals("1-0, 15-0", match.score()); 
		
		for(int i =0 ; i < 3; i++) {
			match.pointWonBy(PLAYER1.getName());
		}
		assertEquals("2-0", match.score()); 
	}
	
	@Test
	public void test_Player2Winscore() {
		for(int i =0 ; i < 4; i++) {
			match.pointWonBy(PLAYER2.getName());
		}
		assertEquals("0-1", match.score()); 
		
		match.pointWonBy(PLAYER2.getName());
		assertEquals("0-1, 0-15", match.score()); 
		
		for(int i =0 ; i < 4; i++) {
			match.pointWonBy(PLAYER2.getName());
		}
		assertEquals("0-2, 0-15", match.score());
	}
	
	@Test
	public void test_MultiGamesWinscore() {
		for(int i =0 ; i < 16; i++) {
			match.pointWonBy(PLAYER1.getName());
		}
		assertEquals("4-0", match.score()); 
		
		for(int i =0 ; i < 21; i++) {
			match.pointWonBy(PLAYER2.getName());
		}
		assertEquals("4-5, 0-15", match.score()); 
	}

}