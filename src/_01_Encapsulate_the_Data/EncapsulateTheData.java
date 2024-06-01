package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

	// 1. Encapsulate all the members.
	private Object memberObj;
	private int itemsReceived;

	private String nomenclature;
	// 2. Implement the setter restrictions described above each member variable.

	// 3. Pass all the JUnit tests.

	/*
	 * All negative arguments should set itemsReceived to 0.
	 */



	public void setItemsReceived(int ir) {

		if (ir < 0) {
			this.itemsReceived = 0;
		} else {
			this.itemsReceived = ir;
		}
	}
	
	/*
	 * degreesTurned must be locked between 0.0 and 360.0 inclusive.
	 * 
	 * All parameters outside this range should set degreesTurned to the nearest
	 * bound.
	 */

	public int getItemsReceived() {
		return itemsReceived;
	}
	private double degreesTurned;
	public double getDegreesTurned() {
		return degreesTurned;
	}



	public void setDegreesTurned(double degreesTurned) {

		if (degreesTurned >= 0.0 && degreesTurned <= 360.0) {
			this.degreesTurned = degreesTurned;
		} else {
			if (degreesTurned < 0) {
				this.degreesTurned = 0.0;
			} else {
				this.degreesTurned = 360.0;
			}
		}
	}
	/*
	 * nomenclature must not contain an empty String.
	 * 
	 * An empty String parameter should set nomenclature to a String with a single
	 * space.
	 */


	public void setNomenclature(String randomString) {
		if(randomString.isEmpty()) {
			this.nomenclature=" ";
		}else {
			this.nomenclature=randomString;
		}
	}
	/*
	 * memberObj must not be a String.
	 * 
	 * A String parameter should set memberObj to a new Object();
	 * 
	 * Hint: Use the instanceof operator.
	 * 
	 * Example:
	 * 
	 * Robot rob = new Robot();
	 * 
	 * System.out.println(rob instanceof Robot); // prints true
	 * 
	 * System.out.println(rob instanceof Random); //prints false
	 */


public void setMemberObj(Object randomObject) {
		if((randomObject instanceof String)) {
		this.memberObj=new Object();
		}else {
			this.memberObj=randomObject;
		}
	}

	public Object getMemberObj() {
	return memberObj;
}

	public String getNomenclature() {
		return nomenclature;
	}

	


}
