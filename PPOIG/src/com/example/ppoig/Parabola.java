package com.example.ppoig;

public class Parabola {
	private float a, b, c;
	
	public Parabola () {
	}	
	
	public Parabola (float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public float getA() {
		return a;
	}



	public void setA(float a) {
		this.a = a;
	}



	public float getB() {
		return b;
	}



	public void setB(float b) {
		this.b = b;
	}



	public float getC() {
		return c;
	}



	public void setC(float c) {
		this.c = c;
	}


	// returns -1, if point is outside parabola
	// returns  0, if point is on the edge of parabola
	// return   1, if point is inside parabola

	public int pointPosition (Point point) {
		
		// 1. Check if point is on the edge of parabola.
		
		float x = point.getX();
		float y = point.getY();
		float yParabola = this.a * x * x + this.b * x + this.c;
		if (pointOnLine(point)) {
			return 0;
		}
		
		// 2. Calculate discriminant for ax^2+bx+(c-y) = 0.
		// If discriminant is negative, point is outside parabola.
		
		float dis = this.b * this.b - 4 * this.a * (this.c - y);
		if (dis < 0) {
			return -1;
		}
		
		// 3. Calculate solutions for x of the quadratic equation
		// If x is not between the solutions, point is outside parabola.
		
		float x1 = (float) ((-this.b - Math.sqrt(dis)) / 2*this.a);
		float x2 = (float) ((-this.b + Math.sqrt(dis)) / 2*this.a);
		
		
		if (x > Float.max(x1,x2) || x < Float.min(x1,x2)) {
			return -1;
		}
		
		// 4. Check if y is inside of parabola for positive and negative a.
		
		if ((this.a > 0 && y < yParabola) || (this.a < 0 && y > yParabola)) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
	public boolean pointOnLine (Point point) {
		final float TRESHOLD = (float) 0.001;
		float x = point.getX();
		float y = point.getY();
		float Y = a*x*x + b*x + c;
		if (Math.abs(Y-y) < TRESHOLD) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return (this.a + "x^2*" + this.b + "x" + this.c);
	}
	
}
