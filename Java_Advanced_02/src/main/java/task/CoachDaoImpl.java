package task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachDaoImpl implements CoachDao {
	
	private final String READALL = "select * from coach";
	private final String INSERT = "insert into coach (firstName, lastName, age, yearsOfExperience) values (?,?,?,?)";
	private final String DELETEBYID = "delete from coach where id=?";
	private final String READBYID = "select * from coach where id=?";
	private final String UPDATEBYID = "update coach set firstName=?, lastName=?, age=?, yearsOfExperience=? where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public CoachDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Coach> readAll() {
		try {
			preparedStatement = connection.prepareStatement(READALL);
			List<Coach> list = new ArrayList<>();
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Coach(
						resultSet.getInt("id"), 
						resultSet.getString("firstName"), 
						resultSet.getString("lastName"), 
						resultSet.getInt("age"), 
						resultSet.getInt("yearsOfExperience")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(String firstName, String lastName, int age, int yearsOfExperience) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setInt(3, age);
			preparedStatement.setInt(4, yearsOfExperience);
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
	public void updateById(int id, Coach coach) {
		try {
			preparedStatement = connection.prepareStatement(UPDATEBYID);
			preparedStatement.setString(1, coach.getFirstName());
			preparedStatement.setString(2, coach.getLastName());
			preparedStatement.setInt(3, coach.getAge());
			preparedStatement.setInt(4, coach.getYearsOfExperience());
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Coach readById(int id) {
		try {
			preparedStatement = connection.prepareStatement(READBYID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Coach(
						resultSet.getInt("id"), 
						resultSet.getString("firstName"), 
						resultSet.getString("lastName"), 
						resultSet.getInt("age"), 
						resultSet.getInt("yearsOfExperience"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
