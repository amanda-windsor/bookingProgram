/*
// Programmer: Amanda Windsor 12197877
// File: Booking.java
// Date: January 23, 2023
// Purpose: COIT11222 assignment twoT322
// Decision Statements
 */


public class Booking
{
	private String bookingName;
	private int nights;
        
        @Override
        public String toString() {
        return String.format("%-30s%-11s%-6s\n", this.bookingName, this.nights, Booking.this.calculateCharge());
        }
        
	Booking()
	{
		bookingName = "";
		nights = 0;
	}

	Booking(String bookingName, int nights)
	{
		this.bookingName = bookingName;
		this.nights = nights;
                
	}

	public void setBookingName(String bookingName)
	{
		this.bookingName = bookingName;
	}

	public String getBookingName()
	{
		return bookingName;
	}

	public void setNights(int nights)
	{
		this.nights = nights;
	}

	public int getNights()
	{
		return nights;
	}
        
        

	public double calculateCharge()
	{
		final double NIGHTLY_CHARGE = 89.95;
		final double CLEANING_CHARGE = 20.00;
		final int DISCOUNT_LIMIT1 = 7;
		final int DISCOUNT_LIMIT2 = 14;
		final double DISCOUNT1 = .1;
		final double DISCOUNT2 = .15;

		double charge = 0.0;
		double discount = 0;

		if (nights > DISCOUNT_LIMIT2)
		{
			discount = DISCOUNT2;
		}
		else if (nights > DISCOUNT_LIMIT1)
		{
			discount = DISCOUNT1;
		}
		else
		{
			discount = 0;
		}

		charge = nights * NIGHTLY_CHARGE;
		charge = charge - (charge * discount);
		charge = charge + CLEANING_CHARGE;


		return charge;
	}
}

