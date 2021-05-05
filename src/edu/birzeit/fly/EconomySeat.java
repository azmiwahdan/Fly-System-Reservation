package edu.birzeit.fly;

public class EconomySeat extends Seat {
	
	public EconomySeat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param seatNum
	 * @param passDetails
	 */
	public EconomySeat(String seatNum, Passenger passDetails) {
		super(seatNum, passDetails);
		// TODO Auto-generated constructor stub
	}
	
	
	// get Seat number for economy seat.
		@Override
		public String getSeatNum(int row, int column) {
			String eS = new String();
			switch (column) {
			case 1:
				eS = String.format("%c%d", 'a', row);
				break;
			case 2:
				eS = String.format("%c%d", 'b', row);
				break;
			case 3:
				eS = String.format("%c%d", 'c', row);
				break;
			case 4:
				eS = String.format("%c%d", 'd', row);
				break;
			case 5:
				eS = String.format("%c%d", 'e', row);
				break;
			case 6:
				eS = String.format("%c%d", 'f', row);

			default:

			}
			return eS.toUpperCase();
		}

}
