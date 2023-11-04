package task;

import java.util.List;

public interface CoachDao {

	public List<Coach> readAll();
	public void insert(String firstName, String lastName, int age, int yearsOfExperience);
	public void deleteById(int id);
	public void updateById(int id, Coach coach);
	public Coach readById(int id); 
	
}
