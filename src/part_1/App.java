/*
 * LOGOS IT ACADEMY
 * 
 */

package part_1;

import java.util.Scanner;

/*
 * @since java 1.8
 * @author Katsiashvili Olena
 * @version 1.1
 */

public class App {

	private enum Seasons {
		WINTER, SPRING, SUMMER, AUTUMN;
	}

	private enum Months {
		JANUARY(Seasons.WINTER, 31), FEBRUARY(Seasons.WINTER, 28), MARCH(Seasons.SPRING, 31), APRIL(Seasons.SPRING, 30),
		MAY(Seasons.SPRING, 31), JUNE(Seasons.SUMMER, 30), JULY(Seasons.SUMMER, 31), AUGUST(Seasons.SUMMER, 31),
		SEPTEMBER(Seasons.AUTUMN, 30), OCTOBER(Seasons.AUTUMN, 31), NOVEMBER(Seasons.AUTUMN, 30),
		DECEMBER(Seasons.WINTER, 31);

		private Seasons season;
		private int day;

		Months(Seasons season, int day) {
			this.season = season;
			this.day = day;
		}

		public Seasons getSeason() {
			return season;
		}

		public int getDay() {
			return day;
		}

	}

	static void menu() {
		System.out.println("Enter: 1 -  For month check");
		System.out.println("Enter: 2 -  Display all months with the same time of year");
		System.out.println("Enter: 3 -  Print all months that have the same number of days");
		System.out.println("Enter: 4 -  Display all months with fewer days");
		System.out.println("Enter: 5 -  Display all months that have more days");
		System.out.println("Enter: 6 -  Display the next season");
		System.out.println("Enter: 7 -  Display the previous season");
		System.out.println("Enter: 8 -  Display all months that have an even number of days");
		System.out.println("Enter: 9 -  Display all months that have an odd number of days");
		System.out.println("Enter: 10 - Display whether the month entered from the console has an even number of days");
	}

	static boolean isMonth(String str) {
		boolean isMonth = false;
		for (Months month : Months.values()) {
			if (str.equalsIgnoreCase(month.name())) {
				isMonth = true;
				break;
			}
		}
		return isMonth;

	}

	static boolean isSeason(String str) {
		boolean isSeason = false;
		for (Seasons seasons : Seasons.values()) {
			if (str.equalsIgnoreCase(seasons.name())) {
				isSeason = true;
				break;
			}
		}
		return isSeason;

	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {
		Scanner scanner = new Scanner(System.in);
		String str;

		Months[] months = Months.values();

		while (true) {
			menu();
			str = scanner.nextLine();
			if (str.equals(""))
				throw new WrongInputConsoleParametersException("No data, please choose number between 1-10");

			switch (str) {
			case "1": {
				System.out.println("Enter month: ");
				str = scanner.nextLine();

				if (isMonth(str))
					System.out.println("Month found");
				if (str.equals(""))
					throw new WrongInputConsoleParametersException("No data, please enter month");
				else
					System.out.println("Data does not exist");

				System.out.println("================================");
				menu();
			}
			case "2": {
				System.out.println("Enter season: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					for (Months month : Months.values()) {
						if (month.getSeason().name().equalsIgnoreCase(str))
							System.out.println(month);
					}
					
				} else
					throw new WrongInputConsoleParametersException("There isn't such season");
				System.out.println("================================");
				break;
			}
			case "3": {
				System.out.println("Enter month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Month with equals days: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() == month.getDay())
							System.out.println(m);
					}
					
				} else
					throw new WrongInputConsoleParametersException("Data does not exist");
				System.out.println("================================");
				break;
			}
			case "4": {
				System.out.println("Enter month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Month that had less days: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() < month.getDay())
							System.out.println(m);
					}
					
				} else
					throw new WrongInputConsoleParametersException("Data does not exist");
				System.out.println("================================");
				break;
			}
			case "5": {
				System.out.println("Enter month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Month that had more days: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() > month.getDay())
							System.out.println(m);
					}
					
				} else
					throw new WrongInputConsoleParametersException("Data does not exist");
				System.out.println("================================");
				break;
			}
			case "6": {
				System.out.println("Enter season: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					System.out.println(Seasons.values()[(Seasons.valueOf(str.toUpperCase()).ordinal() + 1) % 4]);
					
				} else
					throw new WrongInputConsoleParametersException("There isn't such season");
				System.out.println("================================");
				break;
			}
			case "7": {
				System.out.println("Enter season: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					int ord = Seasons.valueOf(str.toUpperCase()).ordinal() - 1;
					System.out.println(Seasons.values()[ord < 0 ? 3 : ord]);
				
				} else
					throw new WrongInputConsoleParametersException("There isn't such season");
				System.out.println("================================");
				break;
			}
			case "8": {
				for (Months month : months) {
					if (month.getDay() % 2 == 0)
						System.out.println(month);
					
				}
				System.out.println("================================");
				break;
			}
			case "9": {
				for (Months month : months) {
					if (month.getDay() % 2 != 0)
						System.out.println(month);

				}
				System.out.println("================================");
				break;
			}
			case "10": {
				System.out.println("Enter month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					Months month = Months.valueOf(str.toUpperCase());
					if (month.getDay() % 2 == 0)
						System.out.println("Your month had even number of days");
					else
						System.out.println("Your month had odd number of days");
					
				} else
					throw new WrongInputConsoleParametersException("Data does not exist");
				System.out.println("================================");
				break;
			}
			}

		}
	}
	
}
