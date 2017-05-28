package entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flight_details {
	
	@Id
	private int flight_id;
	private Date flight_departure_date;
	private float price;
	private int available_seats;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL) 
	@JoinColumn(name = "flight_id", nullable = false)
	
	private Flight flight;
	
	
	public int getFlight_id() {
		return flight_id;
	}


	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}


	public Date getFlight_departure_date() {
		return flight_departure_date;
	}


	public void setFlight_departure_date(Date flight_departure_date) {
		this.flight_departure_date = flight_departure_date;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getAvailable_seats() {
		return available_seats;
	}


	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	@Override
	public String toString() {
		return "Flight_details [flight_id=" + flight_id + ", flight_departure_date=" + flight_departure_date
				+ ", price=" + price + ", available_seats=" + available_seats + ", flight=" + flight + "]";
	}


	
	

}
