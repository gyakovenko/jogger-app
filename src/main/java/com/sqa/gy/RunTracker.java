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

import java.text.*;

import com.sqa.gy.helpers.*;

public class RunTracker {

	// Declaring global variables
	public static String appName = "Run Tracker";
	public static double averageMinRanEachDay;
	public static NumberFormat formatter = new DecimalFormat("#0.0");
	public static int minutesRanEachDay[];
	public static int NUMBEROFDAYS = 7;
	public static String strYes = "y";
	public static int totalMinRanInWeek;
	public static String userName;

	public static void askIfAnotherRound() {
		boolean againOrNo = AppBasics.requestYesorNo("Would you like to enter data for another runner?");
		if (againOrNo == true) {
			runRoundofRunTracker(userName, false);
		} else {
			System.out.println("\nOK.");
		}
	}

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

	/*
	 * Default runner = user If first round, ask if runner = user. If yes:
	 * return that If no: ask for runner name If not first round, ask for runner
	 * name
	 */

	public static String determineRunnerName(String userName, boolean isFirstRound) {
		String nameOfRunner = userName;
		if (isFirstRound == true) {
			// ask if the userName = runnerName
			boolean userIsRunner = determineUserIsRunner();
			if (userIsRunner == false) {
				nameOfRunner = requestRunnerName();
			}
		} else {
			nameOfRunner = requestRunnerName();
		}
		return nameOfRunner;
	}

	public static String determineRunnerType(int minRanInWeek) {
		String locRunnerTypewithRange;
		if (minRanInWeek < 120) {
			locRunnerTypewithRange = "Beginning Runner (less than 120 min per week)";
		} else if (minRanInWeek < 360) {
			locRunnerTypewithRange = "Amateur Runner (between 120 and 360 min per week)";
		} else if (minRanInWeek < 700) {
			locRunnerTypewithRange = "Dedicated Runner (between 360 and 700 min per week)";
		} else if (minRanInWeek <= 1400) {
			locRunnerTypewithRange = "Advanced Runner (between 700 and 1400 min per week)";
		} else {
			locRunnerTypewithRange = "Premium Runner (over 1400 min per week)";
		}
		return locRunnerTypewithRange;
	}

	public static boolean determineUserIsRunner() {
		String strIsUserRunner = AppBasics.requestUserInfo("Is the user name the same as the runner name? (y/n): ");
		return strIsUserRunner.equalsIgnoreCase(strYes);
	}

	public static void main(String[] args) {
		userName = AppBasics.greetUser(appName);
		boolean firstRound = true;
		runRoundofRunTracker(userName, firstRound);
		askIfAnotherRound();
		AppBasics.farewellUser(userName, appName);
		System.exit(0);
	}

	public static int[] requestMinRanEachDay(int numberOfDays) {
		int[] locMinutesRanEachDay = new int[numberOfDays];
		for (int i = 0; i < locMinutesRanEachDay.length; i++) {
			String dayOfWeek = determineDayofWeek(i);
			locMinutesRanEachDay[i] = Integer.parseInt(AppBasics.requestUserInfo("Minutes ran on " + dayOfWeek + ":"));
		}
		return locMinutesRanEachDay;
	}

	public static String requestRunnerName() {
		String locNameOfRunner = AppBasics.requestUserInfo("\nRunner's name: ");
		return locNameOfRunner;
	}

	public static void runRoundofRunTracker(String userName, boolean isFirstRound) {
		String runnerName = determineRunnerName(userName, isFirstRound);

		System.out.println("\nOk, " + runnerName + ", let's get your running data.");

		minutesRanEachDay = requestMinRanEachDay(NUMBEROFDAYS);
		System.out.print("\n");

		System.out.println("Minutes ran each day: " + AppBasics.returnIntArrayAsString(minutesRanEachDay));
		System.out.print("\n");

		totalMinRanInWeek = AppBasics.calcsTotalOfIntsInArray(minutesRanEachDay);
		System.out.println("Total minutes ran this week: " + totalMinRanInWeek);
		averageMinRanEachDay = AppBasics.calcsAverageOfIntsInArray(minutesRanEachDay);
		System.out.println("Average minutes ran each day: " + formatter.format(averageMinRanEachDay));
		System.out.print("\n");

		String runnerType = determineRunnerType(totalMinRanInWeek);
		System.out.println(runnerName + " is a " + runnerType + ".");
		System.out.print("\n");
	}
}
