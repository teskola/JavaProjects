package com.example.ppoig;

import java.util.ArrayList;

public class StringHandler {
	public StringHandler() {}
	
	public Point addPoint (String pointString) {
		Point newPoint = new Point();
		try {
			String[] parts = pointString.split(",");
			if (parts.length > 2) {
				throw new RuntimeException("Something went wrong!");
			}
			float x = Float.parseFloat(parts[0]);
			float y = Float.parseFloat(parts[1]);
			newPoint.setX(x);
			newPoint.setY(y);
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			return null;
			
		}
		return newPoint;
	}
	
	public Parabola addParabola (String parabolaString) {
		Parabola newParabola = new Parabola();
		try  {
		String[] parts = parabolaString.split(",");
		if (parts.length > 3) {
			throw new RuntimeException("Something went wrong!");
		}
		float a = Float.parseFloat(parts[0]);
		newParabola.setA(a);
		
		// For parabola, a must be non-zero
		
		if (a == 0) {
			throw new Exception("Something went wrong!");
		}
		
		float b = Float.parseFloat(parts[1]);
		float c = Float.parseFloat(parts[2]);
		newParabola.setB(b);
		newParabola.setC(c);
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			return null;
		}
		return newParabola;
	}
	
	
	public ArrayList<String> parseDataFromTxt (String inputString) {
		ArrayList<String> data = new ArrayList<String>();
		String[] parts = inputString.split(";");
		for (String point : parts) {
			data.add(point);
		}
		return data;
	}

}
