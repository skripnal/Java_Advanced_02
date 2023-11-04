package task;

public class Coach {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int yearsOfExperience;
	
	public Coach(int id, String firstName, String lastName, int age, int yearsOfExperience) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
	}

	public Coach(String firstName, String lastName, int age, int yearsOfExperience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
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

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString() {
		return "Coach [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", yearsOfExperience=" + yearsOfExperience + "]";
	}
	
	
	
}
