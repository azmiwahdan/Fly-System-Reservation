package edu.birzeit.fly;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Seat  {
	protected int row;
	protected int column ;
	protected String seatNum;
	protected Passenger passDetails;
	/**
	 * 
	 */
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param seatNum
	 * @param passDetails
	 */
	public Seat(String seatNum, Passenger passDetails) {
		this.seatNum = seatNum;
		this.passDetails = passDetails;
	}
	
	
	
	/**
	 * @param seatNum the seatNum to set
	 */
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public abstract String getSeatNum(int row,int column);
	
	
	//print all passengers in a specific trip
	public static void printList(Trip t) {
		ArrayList<Passenger>passengers=new ArrayList<Passenger>();
		System.out.println("Trip Number :"+t.flightNum);
		System.out.println("______________________________________________________________________________________");
		System.out.println("\tList Of Passengers:");
		for(int i=1;i<=31;i++) {
			for(int j=1;j<=6;j++) {
				if(t.seats[i][j]!=null) {
					t.seats[i][j].passDetails.tripAndSeat=t.flightNum+" "+t.seats[i][j].seatNum;
					passengers.add(t.seats[i][j].passDetails);
				}
			}
		}
		for(int i=0;i<passengers.size();i++) {
			System.out.println(passengers.get(i)+"..."+passengers.get(i).tripAndSeat);
		}
		
		
		
		
	}
	
	public static void filePrint(ArrayList<Trip> trips) throws FileNotFoundException {
		Trip t=null;
		PrintWriter write=new PrintWriter("passengers.txt");
		write.println("Trip#: Seat #: FirstName LastName: Gender: Date of birth:Passport #: Nationality: Flight seat preference");
		ArrayList<Passenger>passengers=new ArrayList<Passenger>();
		for (int k = 0; k <trips.size(); k++) {
			t=trips.get(k);
			for(int i=1;i<31;i++) {
				for(int j=1;j<=6;j++) {
					if(t.seats[i][j]!=null) {
						t.seats[i][j].passDetails.tripAndSeat=t.flightNum+":"+t.seats[i][j].seatNum;
						passengers.add(t.seats[i][j].passDetails);
					}
					
				}
			}
				
			
		}
		//print passengers in file of passengers
		for(int i=0;i<passengers.size();i++) {
			Passenger p=passengers.get(i);
			write.println(p.tripAndSeat+":"+p.firstName+" "+p.lastName+":"+p.gender+":"+p.dateOfBirth+":"+p.getPassportNum()+":"+p.getNationality()+":"+p.getFlightPref());
		}
		write.close();
		
		
	}
	
	

}
