package dbService.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Train")
public class Train {
	
	//========================================
	//=              Attributes              =
	//========================================

	@Id
	@GeneratedValue
	@Column(name="t_id")
	private long id;

	@Column(name="t_number")
	private long trainNumber;
	
	@Column(name="stations")
	@OneToMany
	private Set<Station> stations;
	
	@Column(name="t_capacity")
	private int numberOfSeats;

	
	
	//========================================
	//=             Constructors             =
	//========================================
	
	public Train() {
		
	}



	public Train(long trainNumber) {
		super();
		this.trainNumber = trainNumber;
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
	
	//========================================
	//=     hashcode, equals and toString    =
	//========================================
	
	@Override
	public String toString(){
		final StringBuilder sb = new StringBuilder("Train{");
		sb.append("trainNumber=").append(trainNumber);
		sb.append(", stations=");
		
		for(Station st : stations){
			sb.append(st.getStation()).append("|");
		}
		
		sb.append(", number of seats=").append(numberOfSeats);
		sb.append("}");
		return sb.toString();
	}
	
}
