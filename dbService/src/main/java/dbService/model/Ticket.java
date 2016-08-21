package dbService.model;

import javax.persistence.*;

@Entity
@Table(name="Ticket")
public class Ticket {
	
	//========================================
	//=              Attributes              =
	//========================================

	@Id
	@GeneratedValue
	@Column(name="tic_id")
	private long id;

	@Column(name="train")
	private long trainNumber;

	@OneToOne
	private Passenger passenger;


	
	//========================================
	//=             Constructors             =
	//========================================
	
	public Ticket() {
	}



	public Ticket(long trainNumber, Passenger passenger) {
		super();
		this.trainNumber = trainNumber;
		this.passenger = passenger;
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



	public Passenger getPassenger() {
		return passenger;
	}



	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	//========================================
	//=     hashcode, equals and toString    =
	//========================================
}
