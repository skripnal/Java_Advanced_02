package task;

public class KindOfSport {

	private int id;
	private String name;
	
	public KindOfSport(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public KindOfSport(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "KindOfSport [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
