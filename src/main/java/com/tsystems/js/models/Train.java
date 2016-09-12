package com.tsystems.js.models;



import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.dao.HasID;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Train")
@NamedQuery(name=Train.FIND, query =
		"SELECT t FROM Train t "+
		"WHERE t.trainNumber=:trainNumber"
	)
public class Train implements HasID {
	public static final String FIND = "Train.is_in_database";

	//========================================
	//=              Attributes              =
	//========================================

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="TRAIN_NUMBER")
	private long trainNumber;
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "TRAIN_ROUTE")
	private Set<Station> stations;
	
	@Column(name="NUMBER_OF_SEATS")
	private int numberOfSeats;



	
	
	//========================================
	//=             Constructors             =
	//========================================
	
	public Train() {
		
	}

	public Train(int id){
		this.id = id;
	}

	public Train(long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Train(long trainNumber, int numberOfSeats) {
		this.trainNumber = trainNumber;
		this.numberOfSeats = numberOfSeats;
	}

	public Train(long trainNumber, Set<Station> stations, int numberOfSeats) {
		super();
		this.trainNumber = trainNumber;
		this.stations = stations;
		this.numberOfSeats = numberOfSeats;
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

	public long getTrainNumber() {
		return trainNumber;
	}



	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
	}



	public Set<Station> getStations() {
		return stations;
	}



	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}

	

	public int getNumberOfSeats() {
		return numberOfSeats;
	}



	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Train addStation(Station station){
		EntityManager em = GenericDAOIml.neverUsethis();
		Station toInsert = em.find(station.getClass(), station.getId());
		station = (toInsert == null) ? station : toInsert;
		stations.add(station);
		return this;
	}
	
	//========================================
	//=     hashcode, equals and toString    =
	//========================================


	@Override
	public String toString() {
		return "Train{" +
				"id=" + id +
				", trainNumber=" + trainNumber +
				", stations=" + stations +
				", numberOfSeats=" + numberOfSeats +
				'}';
	}
}
