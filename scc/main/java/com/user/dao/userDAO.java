package com.user.dao;

public class userDAO {
	
    import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class UserDAOImpl implements UserDAO {
	    private static final String URL = "jdbc:mysql://localhost:3306/chatbot";
	    private static final String USER = "root";
	    private static final String PASSWORD = "password";

	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    @Override
	    public User getUserById(int userId) {
	        String query = "SELECT * FROM Users WHERE user_id = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, userId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                return new User(
	                    rs.getInt("user_id"),
	                    rs.getString("username"),
	                    rs.getString("email"),
	                    rs.getTimestamp("created_at")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public List<User> getAllUsers() {
	        List<User> users = new ArrayList<>();
	        String query = "SELECT * FROM Users";

	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                users.add(new User(
	                    rs.getInt("user_id"),
	                    rs.getString("username"),
	                    rs.getString("email"),
	                    rs.getTimestamp("created_at")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    @Override
	    public boolean insertUser(User user) {
	        String query = "INSERT INTO Users (username, email, created_at) VALUES (?, ?, ?)";

	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getEmail());
	            stmt.setTimestamp(3, user.getCreatedAt());

	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean updateUser(User user) {
	        String query = "UPDATE Users SET username = ?, email = ? WHERE user_id = ?";

	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getEmail());
	            stmt.setInt(3, user.getUserId());

	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean deleteUser(int userId) {
	        String query = "DELETE FROM Users WHERE user_id = ?";

	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, userId);
	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	}
