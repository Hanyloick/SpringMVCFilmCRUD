package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

// SELECT	
	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

			String sqlStatement = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setInt(1, actorId);
			ResultSet actorResult = preparedStatement.executeQuery();
			// while would be more than 1
			if (actorResult.next()) {
				int id = actorResult.getInt("id");
				String firstName = actorResult.getString("first_name");
				String lastName = actorResult.getString("last_name");

				actor = new Actor(id, firstName, lastName);
			}
			actorResult.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT actor.* FROM actor JOIN film_actor ON film_actor.actor_id = actor.id WHERE film_actor.film_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, filmId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				Actor actor = new Actor(id, firstName, lastName);
				cast.add(actor);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cast;

	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String sqlStaement = "SELECT * From film where id = ?"; 

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);) {
			//"SELECT film.*, language.name, actor.*, category.name "
//					+ "FROM film JOIN film_actor on film_actor.film_id = film.id "
//					+ "JOIN actor on film_actor.actor_id = actor.id "
//					+ "JOIN film_category on film.id = film_category.film_id JOIN category on film_category.category_id = category.id "
//					+ "JOIN language ON film.language_id = language.id " + "WHERE film.id = ?";
			
			preparedStatement.setInt(1, filmId);
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
					int id = resultSet.getInt("id");
					String title = resultSet.getString("title");
					String description = resultSet.getString("description");
					short releaseYear = resultSet.getShort("release_year");
					int languageId = resultSet.getInt("language_id");
					int rentDur = resultSet.getInt("rental_duration");
					double rentalRate = resultSet.getDouble("rental_rate");
					int length = resultSet.getInt("length");
					double replacementCost = resultSet.getDouble("replacement_cost");
					String rating = resultSet.getString("rating");
					String specialFeatures = resultSet.getString("special_features");
//					String language = resultSet.getString("language.name");
//					List<Actor> cast = findActorsByFilmId(id);
//					String category = resultSet.getString("category.name");
					film = new Film(id, title, description, releaseYear, languageId, rentDur, rentalRate, length,
							replacementCost, rating, specialFeatures);
					System.out.println("***************************" + film);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.* FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, actorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int filmId = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				Film film = new Film(filmId, title, descritpion, releaseYear, languageId, rentDur, rentalRate, length,
						replacementCost, rating, specialFeatures);
				films.add(film);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.* FROM film WHERE film.title LIKE ? or film.description LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				Film film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, rentalRate, length,
						replacementCost, rating, specialFeatures);
				films.add(film);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public List<Film> findCopiesCondition(Film film) {
		List<Film> films = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.*, inventory_item.*, language.name, actor.*, category.name FROM film JOIN film_actor on film_actor.film_id = film.id JOIN actor on film_actor.actor_id = actor.id JOIN inventory_item on film.id= inventory_item.film_id JOIN film_category on film.id = film_category.film_id JOIN category on film_category.category_id = category.id JOIN language ON film.language_id = language.id WHERE film.id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setInt(1, film.getFilmId());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				String condition = resultSet.getString("media_condition");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				String language = resultSet.getString("language.name");
				List<Actor> cast = findActorsByFilmId(id);
				String category = resultSet.getString("category.name");
				film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, condition, rentalRate, length,
						replacementCost, rating, specialFeatures, language, cast, category);
				films.add(film);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	public List<Film> getAllInfoOnAllCopiesFilms(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlStaement = "SELECT film.*, inventory_item.*, language.name, actor.*, category.name FROM film JOIN film_actor on film_actor.film_id = film.id JOIN actor on film_actor.actor_id = actor.id JOIN inventory_item on film.id = inventory_item.film_id JOIN film_category on film.id = film_category.film_id JOIN category on film_category.category_id = category.id JOIN language ON film.language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlStaement);
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String descritpion = resultSet.getString("description");
				short releaseYear = resultSet.getShort("release_year");
				int languageId = resultSet.getInt("language_id");
				int rentDur = resultSet.getInt("rental_duration");
				String condition = resultSet.getString("media_condition");
				double rentalRate = resultSet.getDouble("rental_rate");
				int length = resultSet.getInt("length");
				double replacementCost = resultSet.getDouble("replacement_cost");
				String rating = resultSet.getString("rating");
				String specialFeatures = resultSet.getString("special_features");
				String language = resultSet.getString("language.name");
				List<Actor> cast = findActorsByFilmId(id);
				String category = resultSet.getString("category.name");
				Film film = new Film(id, title, descritpion, releaseYear, languageId, rentDur, condition, rentalRate,
						length, replacementCost, rating, specialFeatures, language, cast, category);
				films.add(film);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;

	}

// INSERT	
	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO actor (first_name, last_name) VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newActorId = keys.getInt(1);
					actor.setId(newActorId);

					// call actors getfilm method, if not null and getfilm.size is greater than 0
					if (actor.getFilm() != null && actor.getFilm().size() > 0) {
						// for insert statement
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						// get the ids of any films on actor list and add tp to the film_actor table
						for (Film film : actor.getFilm()) {
							stmt.setInt(1, film.getFilmId());
							stmt.setInt(2, newActorId);
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}
			conn.commit();
			// COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + actor);
		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

// Update only changes rows already in existance!	
	public boolean saveActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE actor SET first_name=?, last_name=? " + " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			stmt.setInt(3, actor.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE actor_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actor.getId());
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
				for (Film film : actor.getFilm()) {
					stmt.setInt(1, film.getFilmId());
					stmt.setInt(2, actor.getId());
					updateCount = stmt.executeUpdate();
				}
				conn.commit(); // COMMIT TRANSACTION

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, "
					+ "rental_rate, length, replacement_cost) " + "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setLong(3, film.getReleaseYear());
			stmt.setLong(4, film.getLangId());
			stmt.setLong(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRate());
			stmt.setLong(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
//			stmt.setString(9, inputFilm.getSpecialFeatures());
			
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					System.out.println("********************" + updateCount + "Added new Film to Database ");
					int newFilmId = keys.getInt(1);
					film.setFilmId(newFilmId);
					System.out.println(newFilmId+ "+++++++++++++++++++++++++++");
					// call film getcast method, if not null and getcast.size is greater than 0
					if (film.getCast() != null && film.getCast().size() > 0) {
						// for insert statement
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						// get the ids of any actors on film list and add tp to the film_actor table
						for (Actor actor : film.getCast()) {
							stmt.setInt(1, newFilmId);
							stmt.setInt(2, actor.getId());
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				film = null;
			}
			conn.commit();
			// COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting Film " + film);
		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public boolean saveFilm(int filmId, Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, "
					+ "rental_duration=?, rental_rate=?, length=?, replacement_cost=? WHERE id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setLong(3, film.getReleaseYear());
			stmt.setLong(4, film.getLangId());
			stmt.setLong(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRate());
			stmt.setLong(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
//			stmt.setString(9, film.getSpecialFeatures());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE film_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, film.getFilmId());
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
				for (Actor actor : film.getCast()) {
					stmt.setInt(1, actor.getId());
					stmt.setInt(2, film.getFilmId());
					updateCount = stmt.executeUpdate();
				}
				conn.commit(); // COMMIT TRANSACTION

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteFilm(int filmId) {
		int updateCount = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			updateCount = stmt.executeUpdate();
			stmt = conn.prepareStatement(sql);
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
