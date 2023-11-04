package task;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Connection connection = ConnectionUtils.openConnection();
		CoachDaoImpl coachDaoImpl = new CoachDaoImpl(connection);
		
		System.out.println("Виведення тренера за ID:");
		System.out.println(coachDaoImpl.readById(2));
		
		System.out.println("\nВиведення всіх тренерів:");
		coachDaoImpl.readAll().forEach(System.out::println);
		
//		System.out.println("\n-Додано тренера-");
//		coachDaoImpl.insert("Олександр", "Скріпніченко", 22, 3);
//		
//		System.out.println("\nВиведення всіх тренерів:");
//		coachDaoImpl.readAll().forEach(System.out::println);
//		
//		System.out.println("\n-Тренера видалено-");
//		coachDaoImpl.deleteById(6);
//		
//		System.out.println("\nВиведення всіх тренерів:");
//		coachDaoImpl.readAll().forEach(System.out::println);
//
//		System.out.println("\n-Зміна тренера-");
//		coachDaoImpl.updateById(6, new Coach("Новий", "Тренер", 33, 12));
//		
//		System.out.println("\nВиведення всіх тренерів:");
//		coachDaoImpl.readAll().forEach(System.out::println);
		
		
		KindOfSportDaoImpl kindOfSportDaoImpl = new KindOfSportDaoImpl(connection);
		
		System.out.println("\nВиведення спорту за ID:");
		System.out.println(kindOfSportDaoImpl.readById(2));
		
		System.out.println("\nВиведення всіх видів спорту:");
		kindOfSportDaoImpl.readAll().forEach(System.out::println);
		
//		System.out.println("\n-Додано вид спорту-");
//		KindOfSport kindOfSport = new KindOfSport("Лижний спорт");
//		kindOfSportDaoImpl.insert(kindOfSport);
//		
//		System.out.println("\nВиведення всіх видів спорту:");
//		kindOfSportDaoImpl.readAll().forEach(System.out::println);
//		
//		System.out.println("\n-Вид спорту видалено-");
//		kindOfSportDaoImpl.deleteById(3);
//		
//		System.out.println("\nВиведення всіх видів спорту:");
//		kindOfSportDaoImpl.readAll().forEach(System.out::println);
//
//		System.out.println("\n-Зміна виду спорту-");
//		kindOfSportDaoImpl.ubdateById(4, new KindOfSport("Новий спорт"));
//		
//		System.out.println("\nВиведення всіх видів спорту:");
//		kindOfSportDaoImpl.readAll().forEach(System.out::println);
		
		
		SportsmenDaoImpl sportsmenDaoImpl = new SportsmenDaoImpl(connection);
		
		System.out.println("\nВиведення спортсмена за ID:");
		System.out.println(sportsmenDaoImpl.readById(2));
		
		System.out.println("\nВиведення всіх спортсменів:");
		sportsmenDaoImpl.readAll().forEach(System.out::println);
		
//		System.out.println("\n-Додано спортсмена-");
//		sportsmenDaoImpl.insert(new Sportsmen("Новий", "Спортсмен", 22, 2, 2));
//		
//		System.out.println("\nВиведення всіх спортсменів:");
//		sportsmenDaoImpl.readAll().forEach(System.out::println);
//		
//		System.out.println("\n-Спортсмена видалено-");
//		sportsmenDaoImpl.deleteById(3);
//		
//		System.out.println("\nВиведення всіх спортсменів:");
//		sportsmenDaoImpl.readAll().forEach(System.out::println);
//
//		System.out.println("\n-Зміна спортсмена-");
//		sportsmenDaoImpl.ubdateById(4, new Sportsmen("Змінений", "Спортсмен", 22, 2, 2));
//		
//		System.out.println("\nВиведення всіх спортсменів:");
//		sportsmenDaoImpl.readAll().forEach(System.out::println);
		
		
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
