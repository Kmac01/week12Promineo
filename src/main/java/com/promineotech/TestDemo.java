package com.promineotech;

import java.util.Random;

public class TestDemo {

	// page 8 instance method 1-2-a
	public int addPositive(int a, int b) {
		// page 8 if 1-2-b
		if ((a <= 0) && (b <= 0)) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}
	// page 13 custom junit test
	// fairly self evident. the method wants the sum of 2 parameters to be 21
	//second half of test found inside TestDemoJUnitTest.java under @Test parameter with documentation
	public int blackJack(int i, int j) {
		if ((i + j) == 21) {
			return (i + j);
		} else {
			throw new IllegalArgumentException("Pick two numbers that equal 21.");
		}
	}
	
	//page 13 4-1 random method. random class imported from java.util.random
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	//page 13 4-1 method moved below getRandomInt so no funny business takes place
	public int randomNumberSquared() {
		//call to get random number
		int i = getRandomInt();
		return (i * i);
	}
	
	
}
