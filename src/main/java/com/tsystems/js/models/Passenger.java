package com.tsystems.js.models;

import com.tsystems.js.dao.HasID;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name= "Passenger")
@NamedQuery(name=Passenger.FIND, query =
			"SELECT p from Passenger p " +
			"WHERE p.passengerName=:name " +
			"AND p.passengerSurname=:surname " +
			"AND p.dateOfBirth=:date")

public class Passenger implements Serializable, HasID {
	public static final String FIND = "Passenger.is_in_database";

	//========================================
	//=              Attributes              =
	//========================================

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name="PASSENGER_NAME")
	private String passengerName;

	@Column(name="PASSENGER_SURNAME")
	private String passengerSurname;


	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	//========================================
	//=             Constructors             =
	//========================================

	public Passenger() {
		
	}

	public Passenger(String passengerName, String passengerSurname,
			Date dateOfBirth) {
		this.passengerName = passengerName;
		this.passengerSurname = passengerSurname;
		this.dateOfBirth = dateOfBirth;
	}

	
	//========================================
	//=         Getters and Setters          =
	//========================================



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerSurname() {
		return passengerSurname;
	}

	public void setPassengerSurname(String passengerSurname) {
		this.passengerSurname = passengerSurname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	//========================================
	//=     hashcode, equals and toString    =
	//========================================
	
	@Override
	public String toString(){
		final StringBuilder sb = new StringBuilder("Passenger{");
		sb.append(", passengerName=").append(passengerName);
		sb.append(", passengerSurname=").append(passengerSurname);
		sb.append(", dateOfBirth=").append(dateOfBirth);
		sb.append("}");
		return sb.toString();
	}
	
}
