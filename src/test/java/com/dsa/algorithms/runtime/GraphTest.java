package com.dsa.algorithms.runtime;

import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.dsa.algorithms.AlgorithmsApplication;
import com.dsa.algorithms.tree.dto.DishRate;

@SpringBootTest(classes = { AlgorithmsApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GraphTest {

	
	@Test
	public void test() {
		int ratings[][] = new int[][] { {512, 2}, {123, 3}, {987, 4}, {123, 5} };
		int result = TestClass.solution(4, ratings);
		System.out.println(result);
	}


	class TestClass {
	    static int solution(int N, int[][] ratings){
	       // Write your code here
	        int result = 0;
	        Set<Integer> reviewedDishes = new TreeSet<>();
	        for(int i = 0; i<N; i++) {
	        	reviewedDishes.add(ratings[i][0]);        		
	        }
	        
	        Map<Integer, Integer> dishesAndRates = new TreeMap<>();
	        for(Integer dish : reviewedDishes) {
	        	int totalRates = 0;
	        	int totalRatesSum = 0;
	        	for(int i = 0; i<N; i++) {
	        		
	        		int dishNumber = ratings[i][0];
	        		if(dishNumber == dish) {
	        			totalRates++;
	        			totalRatesSum = totalRatesSum + ratings[i][1];
	        		}
	        		
	        	}
	        	int totalAverage = totalRatesSum / totalRates;
	        	dishesAndRates.put(dish, totalAverage);
	        }
	        
	        NavigableSet<DishRate> navSet = new TreeSet<>();
	        DishRate firstDishRate = null;
	        for(Map.Entry<Integer, Integer> dishesAndRatesEntry : dishesAndRates.entrySet()) {
	        	DishRate dishRate = new DishRate(dishesAndRatesEntry.getKey(), dishesAndRatesEntry.getValue());
	        	navSet.add(dishRate);
	        }
	        firstDishRate = navSet.descendingSet().first();
	        
	        result = firstDishRate.getNumber();
	        return result;
	    
	    }
	}
	
	
}
