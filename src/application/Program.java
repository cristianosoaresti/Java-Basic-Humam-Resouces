package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import humanResources.entities.Department;
import humanResources.entities.HourContract;
import humanResources.entities.Worker;
import humanResources.entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name ");
		String workerName = sc.nextLine();
		System.out.print("Level(JUNIOR, MID_LEVEL, SENIOR): ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double workerSalary = sc.nextDouble();
		sc.nextLine();

		// Attention with the type enum (WorkerLevel) and the composition of objects
		// (Department)
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary,
				new Department(departmentName));

		System.out.println("=================================================");
		System.out.print("**    How many contracts to this worker? ");
		int contractsNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("=================================================");

		for (int i = 1; i <= contractsNumber; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String stringDate = sc.next();
			Date date = sdf.parse(stringDate);
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			//sc.hasNextLine();
			System.out.print("Duration (hour): ");
			Integer hour = sc.nextInt();
			//sc.hasNextLine();
			HourContract contract = new HourContract(date, valuePerHour, hour);
			worker.addContract(contract);
			System.out.println("contract add success");
		}

		System.out.println("=================================================");
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthYearIncome = sc.next();
		System.out.println("=================================================");
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		// cutting the variable monthYearIncome using sustring.
		// remember: to use substring the first argument is the first position of the
		// string and the second is the last position of the string that you want to 
		// cut + one.
		int month = Integer.parseInt(monthYearIncome.substring(0, 2));
		// if we do not specify the last position of substring, means that we want what
		// remains of the string
		int year = Integer.parseInt(monthYearIncome.substring(3));
		System.out.print("Income for " + monthYearIncome + ": " + worker.income(year, month));

		sc.close();
	}

}