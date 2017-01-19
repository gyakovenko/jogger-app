/**
 *   File Name: AppBasics.java<br>
 *   Yakovenko, Galina<br>
 *   Created: Jan 16, 2017
 *
 */

package com.sqa.gy.helpers;

import java.util.*;

public class AppBasics {

	static Scanner scanner = new Scanner(System.in);

	public static double calcsAverageOfIntsInArray(int[] anArray) {
		int total = calcsTotalOfIntsInArray(anArray);
		double average = (double) total / anArray.length;
		return average;
	}

	public static int calcsTotalOfIntsInArray(int[] anArray) {
		int total = 0;
		for (int i = 0; i < anArray.length; i++) {
			total += anArray[i];
		}
		return total;
	}

	public static void doSomething(String appName, String appActionIng) {
		System.out.println(appName + " App is " + appActionIng);
	}

	public static void farewellUser(String nameOfUser, String appName) {
		System.out.println("\nThanks for using " + appName + ".");
		System.out.println("Bye for now, " + nameOfUser + "!");
	}

	public static String greetUser(String appName) {
		System.out.println("Hello and welcome to the " + appName + " app.");
		System.out.print("What shall I call you? ");
		return scanner.nextLine();
	}

	public static String requestUserInfo(String prompt) {
		System.out.print(prompt + " ");
		String response = scanner.nextLine();
		return response;
	}

	public static boolean requestYesorNo(String prompt) {
		String strYes = "y";
		String response = AppBasics.requestUserInfo(prompt + " (y/n): ");
		return response.equalsIgnoreCase(strYes);
	}

	public static String returnIntArrayAsString(int[] anArray) {
		String arrayInAString = Integer.toString(anArray[0]);
		for (int i = 1; i < anArray.length; i++) {
			{
				arrayInAString = arrayInAString + ", ";
				arrayInAString = arrayInAString + Integer.toString(anArray[i]);
			}
		}
		return arrayInAString;
	}
}
