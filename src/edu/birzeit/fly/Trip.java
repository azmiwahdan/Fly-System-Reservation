package edu.birzeit.fly;


import java.util.Scanner;

public class Trip implements Comparable<Trip> {
	protected Seat[][] seats = new Seat[32][7];
	protected String flightNum;
	protected String fromAirportName;
	protected String toAirportName;
	protected double distance;
	protected String dTime;
	protected String aTime;
	private static Scanner input=new Scanner(System.in);

	// No Arguments Constructor.
	public Trip() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param flightNum
	 * @param fromAirportName
	 * @param toAirportName
	 * @param distance
	 * @param dTime
	 * @param aTime
	 */
	public Trip(String flightNum, String fromAirportName, String toAirportName, double distance, String dTime,
			String aTime) {
		this.flightNum = flightNum;
		this.fromAirportName = fromAirportName;
		this.toAirportName = toAirportName;
		this.distance = distance;
		this.dTime = dTime;
		this.aTime = aTime;
	}

	// Read Trip Information ...Return an object of Trip.
	public static Trip readInfo() {
		input = new Scanner(System.in);
		System.out.println("______________________________________________________________________________________");
		System.out.println("\tEnter trip information :");
		System.out.print("\t\tFlight Name :");
		String flyName = input.next();
		System.out.print("\t\tFrom Airport Name :");
		String fAir = input.next();
		System.out.print("\t\tTo Airport Name :");
		String tAir = input.next();
		System.out.print("\t\tDistance :");
		double d = input.nextDouble();
		System.out.print("\t\tThe departure time(D/M/Y) ");
		String strDate=input.next();
		System.out.print("\t\tThe arrival time(D/M/Y) ");
		String endDate=input.next();
		return new Trip(flyName, fAir, tAir, d, strDate, endDate);


	}

	// TO show Menue
	public static void showMenue() {
		System.out.println("______________________________________________________________________________________");
		System.out.println("\t\t****Hello in BZU Flight Seat Reservation System****\t\t");
		System.out.println("______________________________________________________________________________________");

		System.out.println("\t\t\tChose:\t\t\t");
		System.out.println("\t0) To add a new trip");
		System.out.println("\t1) To list all the trips information sorted by the flight number.  ");
		System.out.println("\t2) To reserve a new empty seat suggested be the system (first class or economy). ");
		System.out.println("\t3) To display the passenger information for a specific seat .");
		System.out.println("\t4)To search for a passenger by first or last name in a specific trip.");
		System.out.println("\t5) To print a list of all the passengers sorted by passport numbers in a specific trip.");
		System.out.println("\t6) To change a passenger seat");
		System.out.println("\t7) To cancel a passenger reservation ");
		System.out.println("\t8) To exit execution ");
		System.out.println("______________________________________________________________________________________");

	}

	// Print Trip's Information
	@Override
	public String toString() {
		return "Trip [  flightNum=" + flightNum + ", fromAirportName=" + fromAirportName + ", toAirportName="
				+ toAirportName + ", distance=" + distance + ", dTime=" +  dTime+
			", aTime=" + aTime + "]";
	}

	public static void reserve(Trip t) {
		Passenger p = Passenger.readInfo();
		input = new Scanner(System.in);
		System.out.println("\tEnter your type want to reserve:");
		System.out.println("\t\t\t\t0):First Class Seat");
		System.out.println("\t\t\t\t1):Economey Seat.");
		int ch = input.nextInt();
		switch (ch) {
		// Reserve First Class Seat
		// ................................................................
		case 0:
			// Window Seat Type..........
			if (p.getFlightPref().equalsIgnoreCase("window")) {
				Seat f = new FirstSeat();
				int i = 1, j = 1;
				String seatNum = null;
				boolean ifDone = false;
				for (i = 1; i <= 3; i++) {
					for (j = 1; j <= 4; j++) {
						if ((j == 4 || j == 1) && t.seats[i][j] == null && !ifDone) {
							seatNum = f.getSeatNum(i, j);
							t.seats[i][j] = new FirstSeat(seatNum, p);
							System.out.println(
									"\tMr/Ms + " + p.firstName + " your Reservation Firstclass Seat is Successfully");
							System.out.println("\t\tyou hava a Window Seat..");
							System.out.println("\t\tyour seatNumber :" + seatNum);
							ifDone = true;
						}
					}

				}

				if (!ifDone)
					System.out.println(
							"\t\t\tSorry all Window Seats in Firstclass Seat are reserved!!!,Try another time..");
				// Aisle Seat Type.............
			} else if (p.getFlightPref().equalsIgnoreCase("aisle")) {
				Seat f = new FirstSeat();
				int i = 1, j = 1;
				String seatNum = null;
				boolean ifDone = false;
				for (i = 1; i <= 3; i++) {
					for (j = 1; j <= 4; j++) {
						if ((j == 2 || j == 3) && t.seats[i][j] == null && !ifDone) {
							seatNum = f.getSeatNum(i, j);
							t.seats[i][j] = new FirstSeat(seatNum, p);
							System.out.println(
									"\tMr/Ms + " + p.firstName + " your Reservation Firstclass Seat is Successfully");
							System.out.println("\t\tyou hava an Aisala Seat..");
							System.out.println("\t\tyour seatNumber :" + seatNum);
							ifDone = true;
						}
					}

				}

				if (!ifDone)
					System.out.println(
							"\t\t\tSorry all Aisala Seats in Firstclass Seat are reserved!!!,Try another time..");

				// Not A Specific Type................
			} else {
				Seat f = new FirstSeat();
				int i = 1, j = 1;
				String seatNum = null;
				boolean ifDone = false;
				for (i = 1; i <= 3; i++) {
					for (j = 1; j <= 4; j++) {
						if (t.seats[i][j] == null && !ifDone) {
							seatNum = f.getSeatNum(i, j);
							t.seats[i][j] = new FirstSeat(seatNum, p);
							System.out.println(
									"\tMr/Ms + " + p.firstName + " your Reservation Firstclass Seat is Successfully");
							System.out.println("\t\tyour seatNumber :" + seatNum);
							ifDone = true;
						}
					}

				}

				if (!ifDone)
					System.out.println("\t\t\tSorry all  Seats in Firstclass Seat are reserved!!!,Try another time..");
			}

			break;

		// Reserve Economey Seat.............................................
		case 1:

			// Window Seat Type........
			if (p.getFlightPref().equalsIgnoreCase("window")) {
				EconomySeat e = new EconomySeat();
				int i = 1, j = 1;
				String seatNum = null;
				boolean ifDone = false;
				for (i = 6; i <= 31 && i!=4 && i!=5 && i!=13; i++) {
					for (j = 1; j <= 4; j++) {
						if ((j == 1 || j == 6) && t.seats[i][j] == null && !ifDone) {
							seatNum = e.getSeatNum(i, j);
							t.seats[i][j] = new FirstSeat(seatNum, p);
							System.out.println(
									"\tMr/Ms + " + p.firstName + " your Reservation Economey Seat is Successfully");
							System.out.println("\t\tyou hava a Window Seat..");
							System.out.println("\t\tyour seatNumber :" + seatNum);
							ifDone = true;
						}
					}

				}

				if (!ifDone)
					System.out.println(
							"\t\t\tSorry all Window Seats in Economey Seat are reserved!!!,Try another time..");

				// Aisle Seat Type......
			} else if (p.getFlightPref().equalsIgnoreCase("aisle")) {
				EconomySeat e = new EconomySeat();
				int i = 1, j = 1;
				String seatNum = null;
				boolean ifDone = false;
				for (i = 6; i <= 31 && i!=4 && i!=5 && i!=13; i++) {
					for (j = 1; j <= 4; j++) {
						if ((j == 3 || j == 4) && t.seats[i][j] == null && !ifDone) {
							seatNum = e.getSeatNum(i, j);
							t.seats[i][j] = new FirstSeat(seatNum, p);
							System.out.println(
									"\tMr/Ms + " + p.firstName + " your Reservation Economey Seat is Successfully");
							System.out.println("\t\tyou hava an Aisala Seat..");
							System.out.println("\t\tyour seatNumber :" + seatNum);
							ifDone = true;
						}
					}

				}

				if (!ifDone)
					System.out.println(
							"\t\t\tSorry all Aisala Seats in Economey Seat are reserved!!!,Try another time..");

				// Not A Specific Type......
			} else {
				EconomySeat e = new EconomySeat();
				int i = 1, j = 1;
				String seatNum = null;
				boolean ifDone = false;
				for (i = 6; i <= 31 && i!=4 && i!=5 && i!=13; i++) {
					for (j = 1; j <= 4; j++) {
						if (t.seats[i][j] == null && !ifDone) {
							seatNum = e.getSeatNum(i, j);
							t.seats[i][j] = new EconomySeat(seatNum, p);
							System.out.println(
									"\tMr/Ms + " + p.firstName + " your Reservation Economey Seat is Successfully");
							System.out.println("\t\tyour seatNumber :" + seatNum);
							ifDone = true;
						}
					}

				}

				if (!ifDone)
					System.out.println("\t\t\tSorry all Seats are reserved!!!,Try another time..");

			}

			break;

		}

	}

	@Override
	public int compareTo(Trip o) {
		return (int) (flightNum.compareToIgnoreCase(o.flightNum));
	}

	// to display the passenger information for a specific seat (if the seat is not
	// empty) in a specific trip.
	public static void findSeat(Trip t) {
		System.out.println("\tEnter your seat number:");
		String seatNumber = input.next();

		try {

			Seat s = isValidSeatNum(t, seatNumber);
			System.out.println("Pass Deatails:" + s.passDetails.toString());
		} catch (SeatNumberException e) {
			System.out.println(e);
		}

		System.out.println("______________________________________________________________________________________");

	}

	// Check if seatNumber valid,
	public static Seat isValidSeatNum(Trip t, String searchSeat) throws SeatNumberException {
		Seat s = null;
		for (int r = 1; r <= 31; r++) {
			for (int c = 1; c <= 6; c++) {
				if (t.seats[r][c] != null) {
					if (t.seats[r][c].seatNum.equalsIgnoreCase(searchSeat)) {
						s = t.seats[r][c];
						break;

					}

				}

			}

		}

		if (s == null) {
			throw new SeatNumberException("\t\tError:seat not reserved!");
		} else {
			return s;
		}
	}

	// New Rservation ......................................................
	public static void changeSeat(Trip t) {
		System.out.println("Enter your present Seat Number");
		String seatNumber = input.next();
		Seat s;
		try {
			s = isValidSeatNum(t, seatNumber);
			Passenger p = s.passDetails;
			System.out.println("Mr/Ms" + s.passDetails.firstName);
			System.out.println("\tLet's get new Seat....");
			System.out.println(
					"\t\tMake sure,that the system will reserve a naew seat foe you just if it's not reserved!");
			System.out.println("\t\tnow choose your wanted :");
			System.out.println("\t\t\t\t0):Firstclass Seat");
			System.out.println("\t\t\t\t0):Economey Seat");
			int ch = input.nextInt();
			switch (ch) {
			case 0:
				//New Rservation OF First Class Seat......................................................
				System.out.print("\tEnter new Flight Seat Preference -if you want change it.");
				String newPref = input.next();
				p.setFlightPref(newPref);
				
				//1:window
				if (p.getFlightPref().equalsIgnoreCase("window")) {
					Seat f = new FirstSeat();
					int i = 1, j = 1;
					String newSeatNum = null;
					boolean ifDone = false;
					for (i = 1; i <= 3; i++) {
						for (j = 1; j <= 4; j++) {
							if ((j == 4 || j == 1) && t.seats[i][j] == null && !ifDone) {
								newSeatNum = f.getSeatNum(i, j);
								s.setSeatNum(newSeatNum);

								System.out.println("\tMr/Ms + " + p.firstName
										+ " your new  Reservation Firstclass Seat is Successfully");
								System.out.println("\t\tyou hava a Window Seat..");
								System.out.println("\t\tyour seatNumber :" + s.seatNum);
								ifDone = true;
							}
						}

					}

					if (!ifDone)
						System.out.println(
								"\t\t\tSorry all Window Seats in Firstclass Seat are reserved!!!,Try another time..");
					//2:Asile
				} else if (p.getFlightPref().equalsIgnoreCase("aisle")) {
					Seat f = new FirstSeat();
					int i = 1, j = 1;
					String newSeatNum = null;
					boolean ifDone = false;
					for (i = 1; i <= 3; i++) {
						for (j = 1; j <= 4; j++) {
							if ((j == 2 || j == 3) && t.seats[i][j] == null && !ifDone) {
								newSeatNum = f.getSeatNum(i, j);
								s.setSeatNum(newSeatNum);
								System.out.println("\tMr/Ms + " + p.firstName
										+ " your new Reservation Firstclass Seat is Successfully");
								System.out.println("\t\tyou hava an Aisala Seat..");
								System.out.println("\t\tyour seatNumber :" + s.seatNum);
								ifDone = true;
							}
						}

					}

					if (!ifDone)
						System.out.println(
								"\t\t\tSorry all Aisala Seats in Firstclass Seat are reserved!!!,Try another time..");
					//None
				} else {
					Seat f = new FirstSeat();
					int i = 1, j = 1;
					String newSeatNum = null;
					boolean ifDone = false;
					for (i = 1; i <= 3; i++) {
						for (j = 1; j <= 4; j++) {
							if (t.seats[i][j] == null && !ifDone) {
								newSeatNum = f.getSeatNum(i, j);
								s.setSeatNum(newSeatNum);

								System.out.println("\tMr/Ms + " + p.firstName
										+ " your new  Reservation Firstclass Seat is Successfully");
								System.out.println("\t\tyour seatNumber :" + s.seatNum);
								ifDone = true;
							}
						}

					}

					if (!ifDone)
						System.out
								.println("\t\t\tSorry all Seats in Firstclass Seat are reserved!!!,Try another time..");
				}

				break;
				//New Reservation OF Economey Seat....................................
			case 1:
				System.out.print("\tEnter new Flight Seat Preference -if you want change it.");
				String newPref2 = input.next();
				p.setFlightPref(newPref2);
				//1:Window
				if (p.getFlightPref().equalsIgnoreCase("window")) {
					EconomySeat e = new EconomySeat();
					int i = 1, j = 1;
					String newSeatNum = null;
					boolean ifDone = false;
					for (i = 6; i <= 31 && i!=4 && i!=5 && i!=13; i++) {
						for (j = 1; j <= 4; j++) {
							if ((j == 1 || j == 6) && t.seats[i][j] == null && !ifDone) {
								newSeatNum = e.getSeatNum(i, j);
								s.setSeatNum(newSeatNum);
								System.out.println("\tMr/Ms + " + p.firstName
										+ " your new Reservation Economey Seat is Successfully");
								System.out.println("\t\tyou hava a Window Seat..");
								System.out.println("\t\tyour seatNumber :" + s.seatNum);
								ifDone = true;
							}
						}
					}

					if (!ifDone)
						System.out.println(
								"\t\t\tSorry all Window Seats in Economey Seat are reserved!!!,Try another time..");
					//2:Aisle
				} else if (p.getFlightPref().equalsIgnoreCase("aisle")) {
					EconomySeat e = new EconomySeat();
					int i = 1, j = 1;
					String newSeatNum = null;
					boolean ifDone = false;
					for (i = 6; i <= 31 && i!=4 && i!=5 && i!=13; i++) {
						for (j = 1; j <= 4; j++) {
							if ((j == 3 || j == 4) && t.seats[i][j] == null && !ifDone) {
								newSeatNum = e.getSeatNum(i, j);
								s.setSeatNum(newSeatNum);
								System.out.println("\tMr/Ms + " + p.firstName
										+ " your new Reservation Economey Seat is Successfully");
								System.out.println("\t\tyou hava an Aisala Seat..");
								System.out.println("\t\tyour seatNumber :" + s.seatNum);
								ifDone = true;
							}
						}

					}

					if (!ifDone)
						System.out.println(
								"\t\t\tSorry all Aisala Seats in Economey Seat are reserved!!!,Try another time..");
					//None
				} else {
					EconomySeat e = new EconomySeat();
					int i = 1, j = 1;
					String newSeatNum = null;
					boolean ifDone = false;
					for (i = 6; i <= 31 && i!=4 && i!=5 && i!=13; i++) {
						for (j = 1; j <= 4; j++) {
							if (t.seats[i][j] == null && !ifDone) {
								newSeatNum = e.getSeatNum(i, j);
								s.setSeatNum(newSeatNum);
								System.out.println("\tMr/Ms + " + p.firstName
										+ " your new Reservation Economey Seat is Successfully");
								System.out.println("\t\tyou hava a Noramal Seat...");
								System.out.println("\t\tyour seatNumber :" + s.seatNum);
								ifDone = true;
							}
						}

					}

					if (!ifDone)
						System.out.println("\t\t\tSorry all Seats are reserved!!!,Try another time..");

				}

				break;

			}

		} catch (SeatNumberException e1) {
			System.out.println(e1);
		}
		System.out.println();

	}

	// To cancel a passenger reservation
	public static void cancelReservation(Trip t) {
		boolean removed = false;
		System.out.println("\t\tEnter your seat Number:");
		String seatNumber = input.next();

		for (int i = 1; i <= 31; i++) {
			for (int j = 1; j <= 6; j++) {
				if (t.seats[i][j] != null && seatNumber.equalsIgnoreCase(t.seats[i][j].seatNum)) {
					t.seats[i][j] = null;
					System.out.println(" Your Reservation is : Canceld,Thank for your time.");
					System.out.println(
							"______________________________________________________________________________________");

					removed = true;

				}

			}

		}
		if (!removed) {
			System.out.println("Error:You are not Reserved this seat,try again!!");
			System.out
					.println("______________________________________________________________________________________");

		}

	}

	
}
