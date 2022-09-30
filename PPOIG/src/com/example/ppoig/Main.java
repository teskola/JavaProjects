package com.example.ppoig;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {

		ArrayList<Point> pointsArray = new ArrayList<Point>();
		ArrayList<Parabola> parabolasArray = new ArrayList<Parabola>();
		ArrayList<String> pointStrings = new ArrayList<String>();
		ArrayList<String> parabolaStrings = new ArrayList<String>();
		FileHandler fh = new FileHandler();
		StringHandler sh = new StringHandler();

		try {

			// Read data from files to arrays. 
			// Expected format for points: x_cordinate1,y_cordinate1;x_cordinate2,y_cordinate2; ...
			// Expected format for parabolas: a1,b1,c1;a2,b2,c2; ...

			pointStrings = (sh.parseDataFromTxt(fh.readFile("pisteet.txt")));
			parabolaStrings = (sh.parseDataFromTxt(fh.readFile("polygoni.txt")));
			fh.createFile("selvitys.txt");

			// Convert Strings to Points and Parabolas

			while (!pointStrings.isEmpty()) {
				String nextString = pointStrings.get(0);
				pointsArray.add(sh.addPoint(nextString));
				pointStrings.remove(0);
			}
			while (!parabolaStrings.isEmpty()) {
				String nextString = parabolaStrings.get(0);
				parabolasArray.add(sh.addParabola(nextString));
				parabolaStrings.remove(0);
			}

			if (parabolasArray.isEmpty()) {
				throw new Exception("Something went wrong!");
			}

			// Check if Point is inside of Parabola for all Points and Parabolas. Write
			// outcome to file.

			while (!pointsArray.isEmpty()) {
				Point nextPoint = pointsArray.get(0);
				for (Parabola parabola : parabolasArray) {
					int outcome = parabola.pointPosition(nextPoint);
					fh.writeFile("selvitys.txt", nextPoint, parabola, outcome);
				}
				pointsArray.remove(0);
			}
		} catch (Exception e) {
			fh.writeFile("selvitys.txt", "Tapahtui virhe.");
		}

	}

}
