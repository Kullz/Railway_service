package dbService.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Station")
public class Station {
	
	//========================================
	//=              Attributes              =
	//========================================
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="st_id")
	private String station;
	
	@Column(name="time_table")
	@OneToMany
	private List<TimeUnit> timeTable;

	
	
	//========================================
	//=             Constructors             =
	//========================================

	public Station() {
	}

	public Station(long id) {
		this.id = id;
	}

	public Station(long id, String station, List<TimeUnit> timeTable) {
		this.id = id;
		this.station = station;
		this.timeTable = timeTable;
	}


	
	//========================================
	//=         Getters and Setters          =
	//========================================
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public List<TimeUnit> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(List<TimeUnit> timeTable) {
		this.timeTable = timeTable;
	}
	
	//========================================
	//=     hashcode, equals and toString    =
	//========================================
	
	@Override
	public String toString(){
		final StringBuilder sb = new StringBuilder("Station{");
		sb.append("id=").append(id);
		sb.append(", station=").append(station);
		sb.append(", timetable=");
		for(TimeUnit tu : timeTable){
			sb.append(tu.getTrainNumber());
			sb.append("-");
			sb.append(tu.getArrivalTime());
			sb.append("|");
		}
		
		sb.append("}");
		return sb.toString();
	}
}
