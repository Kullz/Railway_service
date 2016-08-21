package dbService.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="TimeTable")
public class TimeUnit {

	@Id
	@Column(name="timetable_id")
	private long id;

	@Column(name="train")
	private long trainNumber;
	
	@Column(name="arrival_time")
	private Date arrivalTime;

	
	public TimeUnit() {
		super();
	}

	public TimeUnit(long trainNumber, Date arrivalTime) {
		super();
		this.trainNumber = trainNumber;
		this.arrivalTime = arrivalTime;
	}

	public long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
