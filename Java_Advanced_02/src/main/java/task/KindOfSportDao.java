package task;

import java.util.List;

public interface KindOfSportDao {
	
	public List<KindOfSport> readAll();
	public void insert(KindOfSport kindOfSport);
	public void deleteById(int id);
	public void ubdateById(int id, KindOfSport kindOfSport);
	public KindOfSport readById(int id); 
	
}
