package com.tennisMatchTest.core;

import java.util.HashMap;
import java.util.Map;

public class GlobalVal {
	public static final String ADVANTAGE = "Advantage";
	public static final String DEUCE = "Deuce";
	public static final Integer PLAYER1_INDEX = 0;
	public static final Integer PLAYER2_INDEX = 1;
	public static final Integer ZERO_POINT = 0;
	public static final Integer ONE_POINT = 1;
	public static final Integer TWO_POINTS = 2;
	public static final Integer THREE_POINTS = 3;
	public static final Integer FOUR_POINTS = 4;
	public static final Integer SIX_POINTS = 6;
	public static final Integer SEVEN_POINTS = 7;
	public static final Map<Integer, Integer> scoreConvertMap = new HashMap<Integer, Integer>();
    static {
    	scoreConvertMap.put(0, 0);
    	scoreConvertMap.put(1, 15);
    	scoreConvertMap.put(2, 30);
    	scoreConvertMap.put(3, 40);
    }
}
