/**   File Name: RunTracker.java<br>
 *   Yakovenko, Galina<br>
 *   Created: Jan 18, 2017
 *
 *   Ask user for minutes ran for each day of the week and store in array
 *   Prints array as a string
 *   Calcs and prints total minutes ran
 *   Calcs and prints average minutes ran per day
 */

package com.sqa.gy;

import com.sqa.gy.helpers.*;

public class RunTracker {
	// Declaring public variables
	public static String appName = "Run Tracker";
	public static double averageMinRanEachDay;
	public static int minutesRanEachDay[];
	public static int NUMBEROFDAYS = 7;
	public static int totalMinRanInWeek;
	public static String userName;

	public static String determineDayofWeek(int dayNumber) {
		String dayName = null;
		switch (dayNumber) {
		case 0:
			dayName = "Monday";
			break;
		case 1:
			dayName = "Tuesday";
			break;
		case 2:
			dayName = "Wednesday";
			break;
		case 3:
			dayName = "Thursday";
			break;
		case 4:
			dayName = "Friday";
			break;
		case 5:
			dayName = "Saturday";
			break;
		case 6:
			dayName = "Sunday";
			break;
		default:
			break;
		}
		return dayName;
	}

	public static String determineRunnerType(int minRanInWeek) {
		String locRunnerTypewithRange;
		if (minRanInWeek < 30) {
			locRunnerTypewithRange = "Begginning Runner (less than 30 min per week)";
		} else if (minRanInWeek < 120) {
			locRunnerTypewithRange = "Amateur Runner (between 30 and 120 min per week)";
		} else if (minRanInWeek < 360) {
			locRunnerTypewithRange = "Begginning Runner (between 120 and 360 min per week)";
		} else if (minRanInWeek < 700) {
			locRunnerTypewithRange = "Dedicated Runner (between 360 and 700 min per week)";
		} else if (minRanInWeek <= 1400) {
			locRunnerTypewithRange = "Advanced Runner (between 700 and 1400 min per week)";
		} else {
			locRunnerTypewithRange = "Premium Runner (over 1400 min per week)";
		}
		return locRunnerTypewithRange;
	}

	public static void main(String[] args) {
		userName = AppBasics.greetUser(appName);
		// Request min ran each day and return as array - ints
		System.out.print("\n");
		minutesRanEachDay = requestMinRanEachDay(NUMBEROFDAYS);
		// Print values in array
		System.out.print("\n");
		System.out.println("Minutes ran each day: " + AppBasics.returnIntArrayAsString(minutesRanEachDay));
		// Calculate and Print total min ran in the week totalMinRanInWeek
		System.out.print("\n");
		totalMinRanInWeek = AppBasics.calcsTotalOfIntsInArray(minutesRanEachDay);
		System.out.println("Total minutes ran this week: " + totalMinRanInWeek);
		// Calculate and print av min ran each day
		averageMinRanEachDay = AppBasics.calcsAverageOfIntsInArray(minutesRanEachDay);
		System.out.println("Average minutes ran each day: " + averageMinRanEachDay);
		// Print type of runger (minutes per week range)
		String runnerType = determineRunnerType(totalMinRanInWeek);
		System.out.print("\n");
		System.out.println("You are a " + runnerType + ".");
		AppBasics.farewellUser(userName, appName);
	}

	public static int[] requestMinRanEachDay(int numberOfDays) {
		int[] locMinutesRanEachDay = new int[numberOfDays];
		for (int i = 0; i < locMinutesRanEachDay.length; i++) {
			String dayOfWeek = determineDayofWeek(i);
			locMinutesRanEachDay[i] = Integer.parseInt(AppBasics.requestUserInfo("Minutes ran on " + dayOfWeek + ":"));
		}
		return locMinutesRanEachDay;
	}

}
