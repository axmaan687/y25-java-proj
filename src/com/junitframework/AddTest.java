package com.junitframework;

import static org.junit.jupiter.api.Assertions.*;

import com.armaan.JUnitFrameworkImplementation;


class AddTest {

	@Test
	void test()
	{
		JUnitFrameworkImplementation obj = new JUnitFrameworkImplementation();
		int result = obj.add(10,20);
		assertEquals(30,result);
	}

}
