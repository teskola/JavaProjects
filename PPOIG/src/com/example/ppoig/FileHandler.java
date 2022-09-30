package com.example.ppoig;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileHandler {
	public FileHandler() {
	}

	public String readFile(String filename) {
		String data = new String();
		try {
			File file = new File(filename);			
			Scanner reader = new Scanner(file);
			data = reader.nextLine(); // read first line from file
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong!");			
		}
		
		return data;

	}
	
	public void createFile(String filename) {
		
		// If file already exist, clear the file.
		
		try {
			File file = new File(filename);
			if (file.createNewFile()) {
				System.out.println("File created.");
			}
			else {					
				FileWriter mWriter = new FileWriter(filename);
				mWriter.write("");
				mWriter.close();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}	
	}
	
	public void writeFile(String filename, String error) {
		try {
			FileWriter mWriter = new FileWriter(filename);
			mWriter.write(error);
			mWriter.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void writeFile(String filename, Point point, Parabola parabola, int outcome) {
		try {
			FileWriter mWriter = new FileWriter(filename, true);
			mWriter.write("[" + point.getX() + "," + point.getY() + "] on polynomin " + parabola.toString());
			if (outcome > 0) {
				mWriter.write(" sisäpuolella.\n");
			}
			else if (outcome < 0) {
				mWriter.write (" ulkopuolella.\n");
			}
			else {
				mWriter.write(" rajalla.\n");
			}
			mWriter.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
}
