package task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportsmenDaoImpl implements SportsmenDao{

	private final String READALL = "select * from sportsmen";
	private final String INSERT = "insert into sportsmen (firstName, lastName, age, kindOfSportID, coachID) values (?,?,?,?,?)";
	private final String DELETEBYID = "delete from sportsmen where id=?";
	private final String READBYID = "select * from sportsmen where id=?";
	private final String UPDATEBYID = "update sportsmen set firstName=?, lastName=?, age=?, kindOfSportID=?, coachID=? where id=?";
	
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public SportsmenDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	
	@Override
	public List<Sportsmen> readAll() {
		try {
			preparedStatement = connection.prepareStatement(READALL);
			List<Sportsmen> list = new ArrayList<>();
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Sportsmen(
						resultSet.getInt("id"), 
						resultSet.getString("firstName"), 
						resultSet.getString("lastName"), 
						resultSet.getInt("age"), 
						resultSet.getInt("kindOfSportID"),
						resultSet.getInt("coachID")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(Sportsmen spoetsmen) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, spoetsmen.getFirstName());
			preparedStatement.setString(2, spoetsmen.getLastName());
			preparedStatement.setInt(3, spoetsmen.getAge());
			preparedStatement.setInt(4, spoetsmen.getKindOfSportID());
			preparedStatement.setInt(5, spoetsmen.getCoachID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		try {
			preparedStatement = connection.prepareStatement(DELETEBYID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ubdateById(int id, Sportsmen sportsmen) {
		try {
			preparedStatement = connection.prepareStatement(UPDATEBYID);
			preparedStatement.setString(1, sportsmen.getFirstName());
			preparedStatement.setString(2, sportsmen.getLastName());
			preparedStatement.setInt(3, sportsmen.getAge());
			preparedStatement.setInt(4, sportsmen.getKindOfSportID());
			preparedStatement.setInt(5, sportsmen.getCoachID());
			preparedStatement.setInt(6, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Sportsmen readById(int id) {
		try {
			preparedStatement = connection.prepareStatement(READBYID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Sportsmen(
						resultSet.getInt("id"), 
						resultSet.getString("firstName"), 
						resultSet.getString("lastName"), 
						resultSet.getInt("age"), 
						resultSet.getInt("kindOfSportID"),
						resultSet.getInt("coachID"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
