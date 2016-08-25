package dbService.model;

import dbSerivce.dao.HasID;

import java.util.Date;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name="Station")
@NamedQuery(name=Station.FIND, query =
		"SELECT s from Station s " +
		"WHERE s.station=:station "
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
	@MapKeyColumn (name="ARRIVAL_TIME")
	@Column(name="TRAIN_NUMBER")
	private Map<Date, Long> timeTable;

	
	
	//========================================
	//=             Constructors             =
	//========================================

	public Station() {
	}

	public Station(String station) {
		this.station = station;
	}

	public Station(String station, Map<Date, Long> timeTable) {
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

	public Map<Date, Long> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(Map<Date, Long> timeTable) {
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
