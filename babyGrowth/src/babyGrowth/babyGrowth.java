package babyGrowth;

import java.util.Scanner;
import java.io.*;

public class babyGrowth {

	public static double findCol(double[] arr, int height) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) { // looping through given array arr 

			if (arr[i] > height) { // if the value in the array is greater

				index = i; // looking for index so index is i
				break; // breaking after max is found 
			}

		}
		return index;

	}

	public static void main(String[] args) throws IOException {

		File myFile = new File("BabyGrowth.txt"); // declaring new file "babyGrowth.txt"
		Scanner inputFile = new Scanner(myFile); /// making new scanner 'inputFile'

		double numbers;
		double[][] babyArray = new double[37][9];
		// making an array @babyArray and initializing to row length of 37
		// and column length of 9

		for (int row = 0; row < 37; row++) { // looping through rows
			for (int column = 0; column < 9; column++) { // looping through columns

				numbers = inputFile.nextDouble(); // reading file
				babyArray[row][column] = numbers; // filling array

			}
		}

		// new scanner to scan user input
		Scanner scan = new Scanner(System.in); // new scanner for user input
		System.out.println("Enter the baby's age in month between birth(0) to 36 months: ");

		int babyAge = scan.nextInt(); // scanning for variables

		System.out.println("Enter the baby's height in centimeter between 41-104:");
		int babyHeight = scan.nextInt();// scanning for variables

		double[] percentile = { 3, 5, 10, 25, 50, 75, 90, 97 };

		double toPercentile = percentile[(int) findCol(babyArray[babyAge], babyHeight)];

		System.out.println("Baby's percentile is: " + toPercentile + "%");

		inputFile.close();

	}

}
