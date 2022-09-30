package com.example.ppoig;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParabolaTest {

	@Test
	void test() {

		// Parabola.pointOnLine() test
		Parabola parabola = new Parabola(1, 0, -1);
		Point point = new Point(-1, 0);
		System.out.println(parabola.pointOnLine(point));
		assertEquals(true, point);
		point.setX(1);
		System.out.println(parabola.pointOnLine(point));
		point.setY(2);
		System.out.println(parabola.pointOnLine(point));

		// Parabola.pointPosition() test

		// a > 0:

		Parabola parabolaPositiveA = new Parabola(1, 0, -1);
		Point outsideBelow = new Point(-2, 0);
		Point outsideLeft = new Point(-1.1f, 0);
		Point outsideRight = new Point(1.1f, 0);
		Point inside1 = new Point(0, -0.5f);
		Point onLine = new Point(1, 0);

		System.out.println(parabolaPositiveA.pointPosition(outsideBelow));
		System.out.println(parabolaPositiveA.pointPosition(outsideLeft));
		System.out.println(parabolaPositiveA.pointPosition(outsideRight));
		System.out.println(parabolaPositiveA.pointPosition(inside1));
		System.out.println(parabolaPositiveA.pointPosition(onLine));

		// a < 0:

		Parabola parabolaNegativeA = new Parabola(-1, 0, -1);
		Point outsideAbove = new Point(0, -0.9f);
		Point outsideRight2 = new Point(1.1f, -2);
		Point outsideLeft2 = new Point(-2, -3);
		Point inside2 = new Point(0, -1.1f);
		Point onLine2 = new Point(0, -1);

		System.out.println(parabolaNegativeA.pointPosition(outsideAbove));
		System.out.println(parabolaNegativeA.pointPosition(outsideLeft2));
		System.out.println(parabolaNegativeA.pointPosition(outsideRight2));
		System.out.println(parabolaNegativeA.pointPosition(inside2));
		System.out.println(parabolaNegativeA.pointPosition(onLine2));

	}

}
