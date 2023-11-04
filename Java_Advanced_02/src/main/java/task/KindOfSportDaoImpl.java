package task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KindOfSportDaoImpl implements KindOfSportDao {

	private final String READALL = "select * from kindOfSport";
	private final String INSERT = "insert into kindOfSport (name) values (?)";
	private final String DELETEBYID = "delete from kindOfSport where id=?";
	private final String READBYID = "select * from kindOfSport where id=?";
	private final String UPDATEBYID = "update kindOfSport set name=? where id=?";
	
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	
	public KindOfSportDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	
	@Override
	public List<KindOfSport> readAll() {
		try {
			preparedStatement = connection.prepareStatement(READALL);
			List<KindOfSport> list = new ArrayList<>();
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new KindOfSport(
						resultSet.getInt("id"), 
						resultSet.getString("name") 
						));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(KindOfSport kindOfSport) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, kindOfSport.getName());
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
	public void ubdateById(int id, KindOfSport kindOfSport) {
		try {
			preparedStatement = connection.prepareStatement(UPDATEBYID);
			preparedStatement.setString(1, kindOfSport.getName());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public KindOfSport readById(int id) {
		try {
			preparedStatement = connection.prepareStatement(READBYID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new KindOfSport(
						resultSet.getInt("id"), 
						resultSet.getString("name"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
