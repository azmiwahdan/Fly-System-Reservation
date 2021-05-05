package edu.birzeit.fly;

public abstract class Person implements Comparable<Passenger> {
	protected String firstName;
	protected String lastName;
	protected char gender;
	protected String dateOfBirth;
	public static int numOfPassengers;

	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param dateOfBirth
	 */
	public Person(String firstName, String lastName, char gender, String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		++numOfPassengers;
	}
	public Person(String firstName2, String lastName2, char gender2) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Person [Name= "+ firstName+" " +lastName+", gender=" +Character.toUpperCase( gender)   ;
	}
	// To search by Name.
	public abstract void SearchByName(Trip t);
	
	
	

}
