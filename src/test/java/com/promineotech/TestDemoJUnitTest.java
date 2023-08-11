package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
//page 14 step 4-2-c mockito doReturn import
import static org.mockito.Mockito.doReturn;
//page 14 step 4-2-b mockito import
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
//page 11 import 1-4-j
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//page 9 import 1-4-b
import org.junit.jupiter.params.ParameterizedTest;

class TestDemoJUnitTest {

	//page 9 variable creation 1-4
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	//page 9 annotation change 1-4-b
	@ParameterizedTest
	
	
	//page 11 k
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")


	
	//page 9 name from void to ___ 1-4-c
	//1-4-d adding 4 parameters
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		//page 10 fail line removed
		//page 10 test 1-4-e 
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			//error found ".instanceof" needs to be ".isInstanceof"
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
		
	}
	
	
	

	
	//
	public static Stream<Object> argumentsForAddPositive() {
		
		return Stream.of(arguments(2, 4, 6, false));
	}
	
	
	//page 12 step 2-1 addpositive test
	@Test 
	 void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		//page 13 custom JUnit test 
		//custom test method assertion tests if 11 + 10 = 21 
		//first half of test found in TestDemo.java as blackJack custom method
		assertThat(testDemo.blackJack(11, 10)).isEqualTo(21);
	}
	
	//page 14 randomNumberSquared test
	@Test
	void randomNumberSquared() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
