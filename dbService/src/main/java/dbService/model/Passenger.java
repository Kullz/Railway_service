package dbService.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Passenger")
public class Passenger {
	
	//========================================
	//=              Attributes              =
	//========================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="p_id")
	private long id;
	
	@Column(name="name")
	private String passengerName;
	
	@Column(name="surname")
	private String passengerSurname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	//========================================
	//=             Constructors             =
	//========================================

	public Passenger() {
		
	}

	public Passenger(String passengerName, String passengerSurname,
			Date dateOfBirth) {
		this.id = id;
		this.passengerName = passengerName;
		this.passengerSurname = passengerSurname;
		this.dateOfBirth = dateOfBirth;
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
		sb.append("id=").append(id);
		sb.append(", passengerName=").append(passengerName);
		sb.append(", passengerSurname=").append(passengerSurname);
		sb.append(", dateOfBirth=").append(dateOfBirth);
		sb.append("}");
		return sb.toString();
	}
	
}
