package com.tsystems.js.models;


import com.tsystems.js.dao.HasID;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Ticket")
@NamedQuery(name = Ticket.FIND, query =
		"SELECT t FROM Ticket t " +
		"WHERE t.trainNumber=:trainNumber " +
		"AND t.passenger.passengerSurname=:surname " +
		"AND t.passenger.passengerName=:name " +
		"AND t.passenger.dateOfBirth=:date"
		)
public class Ticket implements HasID, Serializable {
	public static final String FIND = "Ticket.is_in_database";

	//========================================
	//=              Attributes              =
	//========================================

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@JoinColumn(name="TRAIN_NUMBER")
	private Long trainNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PASSENGER_FK")
	private Passenger passenger;


	
	//========================================
	//=             Constructors             =
	//========================================
	
	public Ticket() {
	}



	public Ticket(Long trainNumber, Passenger passenger) {
		super();
		this.trainNumber = trainNumber;
		this.passenger = passenger;
	}
	
	//========================================
	//=         Getters and Setters          =
	//========================================


	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getTrainNumber() {
		return trainNumber;
	}



	public void setTrain(Long trainNumber) {
		this.trainNumber = trainNumber;
	}



	public Passenger getPassenger() {
		return passenger;
	}



	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	//========================================
	//=     hashcode, equals and toString    =
	//========================================


	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", trainNumber=" + trainNumber +
				", passenger=" + passenger +
				'}';
	}
}
