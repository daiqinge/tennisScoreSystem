package com.tennisMatchTest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.tennisMatchTest.api.MatchI;
import com.tennisMatchTest.core.Match;

public class MatchTest {
	String player1Name = "player 1";
	String player2Name = "player 2";
	private MatchI match;

	@Before
	public void beforeGameTest() {
		match = new Match("player 1", "player 2");
	}
	
	@Test
	public void test_gameWinInfo() {
		assertEquals("0-0", match.score());
		
		match.pointWonBy(player1Name);
		assertEquals("0-0, 15-0", match.score());
		
		match.pointWonBy(player2Name);
		assertEquals("0-0, 15-15", match.score());
		
		match.pointWonBy(player2Name);
		assertEquals("0-0, 15-30", match.score());
		
		match.pointWonBy(player2Name);
		assertEquals("0-0, 15-40", match.score());
		
		match.pointWonBy(player1Name);
		assertEquals("0-0, 30-40", match.score());
		
	}
	
	@Test
	public void test_tieBreak() {
		for(int i= 0; i<5; i++) {
			match.pointWonBy(player1Name);
			match.pointWonBy(player2Name);
		}
		assertEquals(false, match.isTieBreak());//5-5
		
		match.pointWonBy(player1Name);
		assertEquals(false, match.isTieBreak());//6-5
		
		match.pointWonBy(player2Name);
		assertEquals(true, match.isTieBreak());//6-6
	}
	
	@Test
	public void test_deuce() {
		for(int i= 0; i<3; i++) {
			match.pointWonBy(player1Name);
		}
		for(int i= 0; i<3; i++) {
			match.pointWonBy(player2Name);
		}
		assertEquals("0-0, Deuce", match.score());
		
		match.pointWonBy(player1Name);
		assertEquals("0-0, Advantage player 1", match.score());
	}

	@Test
	public void test_deuceWinscore() {
		for(int i= 0; i<3; i++) {
			match.pointWonBy(player1Name);
		}
		for(int i= 0; i<3; i++) {
			match.pointWonBy(player2Name);
		}
		match.pointWonBy(player1Name);
		match.pointWonBy(player1Name);
		assertEquals("1-0", match.score());
	}
	
	@Test
	public void test_tieBreakSevenFiveWinscore() {
		for(int i= 0; i<5; i++) {
			match.pointWonBy(player1Name);
			match.pointWonBy(player2Name);
		}
		match.pointWonBy(player1Name);
		match.pointWonBy(player1Name);
		assertEquals("1-0", match.score()); //7-5
	}
	
	@Test
	public void test_tieBreakSixSixWinscore() {
		for(int i= 0; i<6; i++) {
			match.pointWonBy(player1Name);
			match.pointWonBy(player2Name);
		}		
		match.pointWonBy(player1Name);//7-6
		assertEquals("0-0, Advantage " + player1Name, match.score()); 
		
		match.pointWonBy(player1Name);//8-6
		assertEquals("1-0", match.score()); 
	}
	
	@Test
	public void test_Player1Winscore() {
		for(int i =0 ; i < 4; i++) {
			match.pointWonBy(player1Name);
		}
		assertEquals("1-0", match.score()); 
		
		match.pointWonBy(player1Name);
		assertEquals("1-0, 15-0", match.score()); 
		
		for(int i =0 ; i < 3; i++) {
			match.pointWonBy(player1Name);
		}
		assertEquals("2-0", match.score()); 
	}
	
	@Test
	public void test_Player2Winscore() {
		for(int i =0 ; i < 4; i++) {
			match.pointWonBy(player2Name);
		}
		assertEquals("0-1", match.score()); 
		
		match.pointWonBy(player2Name);
		assertEquals("0-1, 0-15", match.score()); 
		
		for(int i =0 ; i < 4; i++) {
			match.pointWonBy(player2Name);
		}
		assertEquals("0-2, 0-15", match.score());
	}
	
	@Test
	public void test_MultiGamesWinscore() {
		for(int i =0 ; i < 16; i++) {
			match.pointWonBy(player1Name);
		}
		assertEquals("4-0", match.score()); 
		
		for(int i =0 ; i < 21; i++) {
			match.pointWonBy(player2Name);
		}
		assertEquals("4-5, 0-15", match.score()); 
	}

}
