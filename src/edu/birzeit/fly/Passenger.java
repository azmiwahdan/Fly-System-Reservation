package edu.birzeit.fly;

import java.util.Scanner;

public class Passenger extends Person {
	private String passportNum;
	private String nationality;
	private String flightPref;
	private static Scanner input;
	protected String tripAndSeat="";

	/**
	 * 
	 */
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param dateOfBirth
	 */
	public Passenger(String firstName, String lastName, char gender, String dateOfBirth, String passportNum,
			String nationality, String flightPref) {
		super(firstName, lastName, gender, dateOfBirth);
		this.passportNum = passportNum;
		this.nationality = nationality;
		this.flightPref = flightPref;
	}

	public Passenger(String firstName, String lastName, char gender, String passportNum, String nationality,
			String flightPref) {
		super(firstName, lastName, gender);
		this.passportNum = passportNum;
		this.nationality = nationality;
		this.flightPref = flightPref;
	}

	/**
	 * @return the passportNum
	 */
	public String getPassportNum() {
		return passportNum;
	}

	/**
	 * @param passportNum the passportNum to set
	 */
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the flightPref
	 */
	public String getFlightPref() {
		return flightPref;
	}

	/**
	 * @param flightPref the flightPref to set
	 */
	public void setFlightPref(String flightPref) {
		this.flightPref = flightPref;
	}

	@Override
	public int compareTo(Passenger o) {
		return(int) (getPassportNum().compareTo(o.getPassportNum()));
	}

	

	// Read Passenger information;
	public static Passenger readInfo() {
		System.out.println("______________________________________________________________________________________");

		input = new Scanner(System.in);
		System.out.println("\tEnter Your Information:");
		System.out.print("\t\tFirst Name:");
		String fName = input.next();
		System.out.print("\t\tLast Name:");
		String lName = input.next();
		System.out.print("\t\tGender:");
		char g = input.next().charAt(0);
		System.out.print("\t\tDate of Birth(D/M/Y):");
		String dateOfBirth=input.next();
		
		System.out.print("\t\tPassport Number:");
		String passNum = input.next();
		System.out.print("\t\tNationality:");
		String nationality = input.next();

		System.out.print("\t\tWhich Flight Seat Preference ? :");
		String pSeat = input.next();
		System.out.println("______________________________________________________________________________________");

		return new Passenger(fName, lName, g, dateOfBirth, passNum, nationality, pSeat);
	}

	// print details for passanger
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " Passport  :" +this. getPassportNum();
	}

	// Implementation of serchByName's method...
	@Override
	public void SearchByName(Trip t) {
		input = new Scanner(System.in);
		System.out.println("\t chose type of search:");
		System.out.println("\t\t\t0):to Search by First Name");
		System.out.println("\t\t\t1):to Search by Last Name");

		int ch = input.nextInt();
		switch (ch) {
		case 0:
			System.out.println("\t\tEnter a First Name:");
			String fName = input.next();
			Seat s = null;
			for (int r = 1; r <= 31; r++) {
				for (int c = 1; c <= 6; c++) {
					if (t.seats[r][c] != null) {
						if (t.seats[r][c].passDetails.firstName.equalsIgnoreCase(fName)) {
							s = t.seats[r][c];
							break;

						}

					}
				}
			}
			if (s != null) {
				System.out.println("\t\tPassenger Details :");
				System.out.println(s.passDetails.toString());
				System.out.println(
						"______________________________________________________________________________________");

			} else {
				System.out.println("\t\t\tError : Invalid First Name!!");
				System.out.println(
						"______________________________________________________________________________________");

			}

			break;
		case 1:
			System.out.println("\t\tEnter a Last Name:");
			String lName = input.next();
			s = null;
			for (int r = 1; r <= 31; r++) {
				for (int c = 1; c <= 6; c++) {
					if (t.seats[r][c] != null) {
						if (t.seats[r][c].passDetails.lastName.equalsIgnoreCase(lName)) {
							s = t.seats[r][c];
							break;

						}

					}
				}
			}
			if (s != null) {
				System.out.println("\t\tPassenger Details :");
				System.out.println(s.passDetails.toString());
				System.out.println(
						"______________________________________________________________________________________");

			} else {
				System.out.println("\t\t\tError : Invalid Last Name!!");
				System.out.println(
						"______________________________________________________________________________________");

			}

			break;
		default:
			System.out.println("\t\tError:Wrong choice!!,Try Again");
			System.out
					.println("______________________________________________________________________________________");

		}

	}

}
