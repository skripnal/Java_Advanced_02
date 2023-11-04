package task;

import java.util.List;

public interface SportsmenDao {

	public List<Sportsmen> readAll();
	public void insert(Sportsmen spoetsmen);
	public void deleteById(int id);
	public void ubdateById(int id, Sportsmen sportsmen);
	public Sportsmen readById(int id); 
	
}
