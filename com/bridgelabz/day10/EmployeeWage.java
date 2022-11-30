package com.bridgelabz.day10;

import java.util.Random;

public class EmployeeWage {

	public String compName;
	public int totalWage = 0;
	public int totalDays;
	public int totalHours;

	EmployeeWage(String compName) {
		this.compName = compName;
	}

	public boolean isEmployeePresent(int p) {
		if (p == 1 || p == 2)
			return true;
		else
			return false;
	}

	public int calculateWage(int p, int wagePerHour, int prtHours, int fullHours) {
		int wage = 0;
		if (isEmployeePresent(p)) {
			if (p == 2)
				wage = wagePerHour * prtHours;
			else
				wage = wagePerHour * fullHours;
		} else
			wage = 20 * 0;

		return wage;
	}

	public int calculateMonthlyWage(int p, int wagePerHour, int prtHours, int fullHours) {
		int wage = 0;
		if (isEmployeePresent(p)) {
			if (p == 2)
				wage = 20 * wagePerHour * prtHours;
			else
				wage = 20 * wagePerHour * fullHours;
		} else
			wage = 20 * wagePerHour * 0;

		return wage;
	}

	public void monthlyCalculatedWage(int days, int hours, int prtHours, int fullHours, int wagePerHOur) {
		Random rnd = new Random();
		int dayCount = 0;
		int hrs = 0;

		while (dayCount < days && hrs < hours) {
			int p = rnd.nextInt(3);
			dayCount++;
			switch (p) {
			case 0:
				// System.out.println("Employee is absent");
				// System.out.println("Employee daily wage is " + calculateWage(p, wagePerHOur,
				// prtHours, fullHours));
				hrs += 0;
				totalWage += 0;
				break;
			case 1:
				System.out.println("Employee is present full time");
				System.out.println("Employee daily wage is " + calculateWage(p, wagePerHOur, prtHours, fullHours));

				if ((hrs + fullHours) > hours) {
					int extra = (hrs + fullHours) - hours;
					hrs += (fullHours - extra);
					totalWage += wagePerHOur * extra;
				} else {
					hrs += fullHours;
					totalWage += wagePerHOur * fullHours;
				}
				break;
			case 2:
				System.out.println("Employee is present part time");
				System.out.println("Employee daily wage is " + calculateWage(p, wagePerHOur, prtHours, fullHours));
				if ((hrs + prtHours) > hours) {
					int extra = (hrs + prtHours) - hours;
					hrs += (prtHours - extra);
					totalWage += wagePerHOur * extra;
				} else {
					hrs += prtHours;
					totalWage += wagePerHOur * prtHours;
				}
				break;
			default:
				break;
			}

		}
		this.totalDays = dayCount;
		this.totalHours = hrs;
	}

	public String toString() {
		return "Total Wage for company " + compName + " for " + totalDays + " days and " + totalHours + " hours is "
				+ totalWage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to employee wage computaion program!");

//							if(emp.isEmployeePresent(p))
//								System.out.println("Employee is present!");
//							else
//								System.out.println("Employee is absent!");
//							
//							if(p == 2)
//								System.out.println("Employee is part time");
//							else
//								System.out.println("Employee is full time");
//							
//							int wage = emp.calculateWage(p);
//							System.out.println("Employee wage is " + wage);

		EmployeeWage reliance = new EmployeeWage("reliance");
		reliance.monthlyCalculatedWage(30, 100, 4, 8, 20);
		System.out.println(reliance.toString());
		System.out.println("\n");
		EmployeeWage jio = new EmployeeWage("jio");
		jio.monthlyCalculatedWage(20, 60, 3, 10, 30);
		System.out.println(jio.toString());

	}

}
