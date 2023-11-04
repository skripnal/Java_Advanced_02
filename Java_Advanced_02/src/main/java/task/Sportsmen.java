package task;

public class Sportsmen {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int kindOfSportID;
	private int coachID;
	
	public Sportsmen(int id, String firstName, String lastName, int age, int kindOfSportID, int coachID) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.kindOfSportID = kindOfSportID;
		this.coachID = coachID;
	}
	
	public Sportsmen(String firstName, String lastName, int age, int kindOfSportID, int coachID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.kindOfSportID = kindOfSportID;
		this.coachID = coachID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getKindOfSportID() {
		return kindOfSportID;
	}

	public void setKindOfSportID(int kindOfSportID) {
		this.kindOfSportID = kindOfSportID;
	}

	public int getCoachID() {
		return coachID;
	}

	public void setCoachID(int coachID) {
		this.coachID = coachID;
	}

	@Override
	public String toString() {
		return "Sportsmen [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", kindOfSportID=" + kindOfSportID + ", coachID=" + coachID + "]";
	}
	
	
	
}
