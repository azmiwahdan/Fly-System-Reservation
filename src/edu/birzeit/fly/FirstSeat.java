package edu.birzeit.fly;

public class FirstSeat extends Seat {

	public FirstSeat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param seatNum
	 * @param passDetails
	 */
	public FirstSeat(String seatNum, Passenger passDetails) {
		super(seatNum, passDetails);
		// TODO Auto-generated constructor stub
	}

	// get Seat number for first class seat.
	@Override
	public String getSeatNum(int row, int column) {
		String bs = new String();
		switch (column) {
		case 1:
			bs = String.format("%c%d", 'a', row);
			break;
		case 2:
			bs = String.format("%c%d", 'b', row);
			break;
		case 3:
			bs = String.format("%c%d", 'c', row);
			break;
		case 4:
			bs = String.format("%c%d", 'd', row);
			break;
		default:

		}
		return bs.toUpperCase();
	}

	

}
