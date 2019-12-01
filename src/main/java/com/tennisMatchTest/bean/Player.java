package com.tennisMatchTest.bean;

public class Player {
	private String name;
	private int score;
	private String scoreDescription;
	
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getScoreDescription() {
		return scoreDescription;
	}
	public void setScoreDescription(String scoreDescription) {
		this.scoreDescription = scoreDescription;
	}

}
