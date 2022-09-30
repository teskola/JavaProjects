package com.example.ppoig;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHandlerTest {

	@Test
	void test() {
		
		// StringHandler.addPoint() test
		
		StringHandler stringHandlerTest = new StringHandler();
		stringHandlerTest.addPoint("1,2,3"); // When more than 2 numbers are used, exception is thrown 
		stringHandlerTest.addPoint("1"); // When less than than 2 numbers are used, exception is thrown 
		stringHandlerTest.addPoint(null); 
		stringHandlerTest.addPoint("1,X"); // When non-number is used, parseFloat throws an exception.
		stringHandlerTest.addPoint("1.5,2.34"); // Two numbers used, no exception is thrown
		
		// StringHandler.addParabol() test
		
		 stringHandlerTest.addParabola("1,2,3,4"); // When more than 3 numbers are used, exception is thrown 
		 stringHandlerTest.addParabola("1,2"); // When less than 3 numbers are used, exception is thrown 
		 stringHandlerTest.addParabola(null); 
		 stringHandlerTest.addParabola("1,X,3"); // When non-number is used, parseFloat throws an exception.
		 stringHandlerTest.addParabola("0,1,2"); // When a=0, exception is thrown.
		 stringHandlerTest.addParabola("1,0,-1"); // Three numbers used, a non-zero, no exception is thrown.
		
	}

}
