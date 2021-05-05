//Azmi Wahdan
//Birzeit university
//Computer Science .
//Advanced programming language(java) project

package edu.birzeit.fly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	private static ArrayList<Trip> trips;

	private static Scanner input;
	static Trip t;

	// To Add a Trip
	public static void addTrip()  {
		t = Trip.readInfo();
		trips.add(t);
		System.out.println("The Trip Added  is successfully ");
		System.out.println("______________________________________________________________________________________");
		System.out.println("" + t);
		
	}

	public static void main(String[] args) throws FileNotFoundException {
	input = new Scanner(System.in);
	trips = new ArrayList<Trip>();
	
	
	//Reads Trips from file...
	File fileOfTrips = new File("Trip.txt");
	if (fileOfTrips.exists()) {
		try {
			String strDate = null;
			String arrDate = null;
	
			Scanner in = new Scanner(fileOfTrips);
			if (in.hasNext())
				in.nextLine();
			String[] t = null;
			while (in.hasNext()) {
	
				t = in.nextLine().trim().split(":");
	
			
					strDate = t[4];
					arrDate = t[5];
	
					trips.add(new Trip(t[0], t[1], t[2], Double.parseDouble(t[3]), strDate, arrDate));
	
				
	
			}
	
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	} else {
		System.out.println("File Not found!");
	}
		
		int selcion;
		
		reserve();//Reservation for passenger in the file
		do {
			System.out.println("num of persons "+ Person.numOfPassengers);
			Trip.showMenue();
			selcion = input.nextInt();
			switch (selcion) {
			case 0: // Add new Trip .
	
				addTrip();
	
				break;
			case 1: // Sort All trips.
	
				sortTrips();
				break;
			case 2: // Reserve A new seat..
	
				t = readTrip();
				if (t != null) {
					Trip.reserve(t);
				} else {
					System.out.println("\t\tError:Invalid Trip.");
				}
				break;
			case 3: // display the passenger information for a specific seat
	
				t = readTrip();
				if (t != null) {
					Trip.findSeat(t);
					
				} else {
					System.out.println("\t\tError:Invalid Trip.");
				}
	
				break;
			case 4: // To search for a passenger by first or last name
	
				t = readTrip();
				if (t != null) {
					Passenger p = new Passenger();
					p.SearchByName(t);
					;
				} else {
					System.out.println("\t\tError:Invalid Trip.");
				}
				break;
	
			case 5:// To print a list of all the passengers
				t = readTrip();
				if (t != null) {
					Seat.printList(t);
	
				} else {
					System.out.println("\t\tError:Invalid Trip.");
				}
				break;
	
			case 6:// To change a passenger seat
				t = readTrip();
				if (t != null) {
					Trip.changeSeat(t);
	
				} else {
					System.out.println("\t\tError:Invalid Trip.");
				}
				break;
	
			case 7:// To cancel a passenger reservation
				t = readTrip();
				if (t != null) {
					Trip.cancelReservation(t);
				} else {
					System.out.println("\t\tError:Invalid Trip.");
				}
				break;
			case 8:// To exit execution
				printInFile();//print in trips's file...
				Seat.filePrint(trips);//print in passengers's file....
				System.out.println("\t\tGoodBye********Enjoy!!\t\t");
				System.out.println(
						"\n__________________________________________________________________________________");
				System.out.println("\t\t\tBy Azmi Wahdan\t\t***");
				System.out.println(
						"\n__________________________________________________________________________________");
				break;
	
			default:
				System.err.println("\t\tError :Wrong Choice,try again!!!");
	
				break;
	
			}
	
		} while (selcion!=8);
	}


	// Read a Trip
	public static Trip readTrip() {
		System.out.println("Enter the trip number:");
		String tripNum = input.next();
		// Search for the trip
		for (int i = 0; i < trips.size(); i++)
			if (trips.get(i).flightNum.equalsIgnoreCase(tripNum))
				return trips.get(i);

		return null;
	}

	// sorted trips by flight number
	public static void sortTrips() {
		java.util.Collections.sort(trips);
		System.out.println("\tList of Sorted Trips by (flight Number):\n");

		// print sorted list of trips...
		for (int i = 0; i < trips.size(); i++) {
			System.out.println("\t\tTrip Num " + (i + 1) + ":" + trips.get(i).toString() + "\n");
		}
		System.out.println("______________________________________________________________________________________");

	}

	// read passengers from file then get Resrtvation for every on of them...
	public static void reserve() {
		File fileOfPassengers = new File("Passengers.txt");
		if (fileOfPassengers.exists()) {
			try {

				Scanner in = new Scanner(fileOfPassengers);
				if (in.hasNext())
					in.nextLine();

				String[] t = null;
				while (in.hasNext()) {

					t = in.nextLine().split(":");
					String[] namT = t[2].trim().split(" ");
					for(int i=0;i<t.length;i++) {
						t[i].trim().split(":");
					}

					String seatNum = t[1];
					char c = seatNum.charAt(0);
					int n = Integer.parseInt(seatNum.substring(1));

					
					Passenger p = new Passenger(namT[0], namT[1], t[3].charAt(0), t[4], t[5], t[6], t[7]);
						for (int i = 0; i < trips.size(); ++i) {
							if (trips.get(i).flightNum.equalsIgnoreCase(t[0])) {
								Seat seat;
								if(n>4) {
									seat=new EconomySeat(seatNum,p);
								}else {
									seat=new FirstSeat(seatNum,p);
								}
								trips.get(i).seats[n][c - 64]=seat;
							}

						}


					

				}

				in.close();
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("File Not found!");
		}

	}
	//print Trips in Trip file
	public static void printInFile() throws FileNotFoundException {
		java.util.Collections.sort(trips);
		PrintWriter write=new PrintWriter("Trip.txt");
		write.println("Flight number:From airport name:To airport name:The trip distance:The departure time:The arrival time");
		for(int i=0;i<trips.size();i++) {
			
			write.println(trips.get(i).flightNum+":"+trips.get(i).fromAirportName+":"+trips.get(i).toAirportName+":"+trips.get(i).distance+":"+trips.get(i).dTime +":"+trips.get(i).aTime);
		}
		write.close();
		
		
	}
	
	

}
