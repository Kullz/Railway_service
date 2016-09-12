package com.tsystems.js.models;

import com.tsystems.js.dao.HasID;

import java.sql.Time;
import java.util.Date;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name="Station")
@NamedQuery(name=Station.FIND, query =
		"SELECT s from Station s " +
		"WHERE s.station=:station"
		)
public class Station implements HasID {
	public static final String FIND = "Station.is_in_database";

	//========================================
	//=              Attributes              =
	//========================================
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name="STATION_NAME")
	private String station;

	@ElementCollection
	@JoinTable(name = "Time_table")
	@Column (name="ARRIVAL_TIME")
	@MapKeyColumn(name="TRAIN_NUMBER")
	private Map<Long, Time> timeTable;

	
	
	//========================================
	//=             Constructors             =
	//========================================

	public Station() {
	}

	public Station(int id){
		this.id = id;
	}

	public Station(String station) {
		this.station = station;
	}

	public Station(String station, Map<Long, Time> timeTable) {
		this.station = station;
		this.timeTable = timeTable;
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

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Map<Long, Time> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(Map<Long, Time> timeTable) {
		this.timeTable = timeTable;
	}

	//========================================
	//=     hashcode, equals and toString    =
	//========================================

	@Override
	public String toString() {
		return "Station{" +
				"id=" + id +
				", station='" + station + '\'' +
				", timeTable=" + timeTable +
				'}';
	}
}
