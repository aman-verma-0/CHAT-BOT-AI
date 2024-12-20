/*package com.user.dao;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.user;

public class userDAO {

	    private static final String jdbcURL = "jdbc:mysql://localhost:3306/chatbot";
	    private static final String jdbcUserName = "root";
	    private static final String PASSWORD = "password";
	    
	    
	    private static final String INSERT_USER_SQL="INSERT INTO users"+"(user_name,email,country,passwd)  values" +"(?,?,?,?);";
	    private static final String select_user_by_id="select * from users where id=?";
	    private static final String select_all_users="select * from users;";
	    private static final String delete_users_sql="delete from users where id=?;";
	    private static final String update_users_sql="update users set user_name=?, email=?,country=?,password=? where ID=?;";
		public userDAO() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    public Connection getConnection()
	    {
	    	Connection connection=null;
	    	
	    	try
	    	{
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		connection=DriverManager.getConnection(jdbcURL,jdbcUserName, PASSWORD);
	    		
	    		
	    	}
	    	catch(SQLException e)
	    	{
	    		
	    	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return connection ;
	    }
	   
	    
	    public void insertUser(user user)
	    {
	    	userDAO dao=new userDAO(); 
	    	
	    	try(Connection connection=dao.getConnection())
	    	{
	    		PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
	    		preparedStatement.setString(1, user.getName());
	    		preparedStatement.setString(2, user.getEmail());
	    		preparedStatement.setString(3, user.getCountry());
	    		preparedStatement.setString(4, user.getPassword());
	    		
	    		preparedStatement.executeUpdate();
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    	
	    }
	    
	    
	    public user selectUser (int id) 
	    {
	    	user user=new user();
	    	userDAO dao=new userDAO();
	    	
	    	try(Connection connection=dao.getConnection())
	    	{
	    		PreparedStatement preparedStatement=connection.prepareStatement(select_user_by_id);
	    		preparedStatement.setInt(1, id);
	    		
	    		ResultSet resultSet=preparedStatement.executeQuery();
	    		
	    		while(resultSet.next())
	    		{
	    			user.setId(id);
	    			user.setName(resultSet.getNString("user_name"));
	    			user.setEmail(resultSet.getString("email"));
	    			user.setCountry(resultSet.getString("country"));
	    			user.setPassword(resultSet.getString("passwd"));
	    			
	    		}
	    		
	    		
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return user;
	    	
	    public List<user> selectAllUsers()
	    {
	    	List<user> users=new ArrayList<user>();
	    	userDAO dao=new userDAO();
	    	try(Connection connection=dao.getConnection())
	    	{
	    		PreparedStatement preparedStatement=connection.prepareStatement(select_all_users);
	    		ResultSet resultSet=preparedStatement.executeQuery();
	    		
	    		
	    		while(resultSet.next())
	    		{
	    			int id =resultSet.getInt("id");
	    			String user_name=resultSet.getString("user_name");
	    			String email=resultSet.getNString("email");
	    			String country=resultSet.getString("country");
	    			String password=resultSet.getString("passwd");
	    			
	    			users.add(new user(id,user_name,email,country,password));
	    			
	    		}
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return user;
	    
	    	
	    }
	    
	 public boolean deleteUser(int id ) 
	 {
		 boolean status =false;
		 userDAO dao=new userDAO();
		 
		 try(Connection connection=dao.getConnection())
	    	{
			 
	    	}
			  
			 
			 
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	 }
	    	
	    	
	    	
	    	
	    
}*/




package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class userDAO {
	
	private String jdbcURL="jdbc:mysql://localhost:3306/userdb";
	private String jdbcUserName="root";
	private String jdbcPassword="root";
	
	private static final String INSERT_USERS_SQL="INSERT INTO users"+"(uname,email,country,passwd) VALUES "+"(?,?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECT * FROM users where id=?;";
	private static final String SELECT_ALL_USERS="select * from users;";
	private static final String DELETE_USERS_SQL="delete from users where id=?;";
	private static final String UPDATE_USERS_SQL="update users set uname=?, email=?, country=? where id=?;";
	
	
	public userDAO() {


	} 
	//database connection
	public Connection getConnection()
	{
		Connection connection=null;
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public void insertUser(User user)
	{
		userDAO dao=new userDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setString(4, user.getPassword());
			
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public User selectUser(int id)
	{
		User user=new User();
		userDAO dao=new userDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet  resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
			user.setId(id);	
			user.setName(resultSet.getString("uname"));
			user.setEmail(resultSet.getString("email"));
			user.setCountry(resultSet.getString("country"));
			user.setPassword(resultSet.getString("passwd"));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	
	public List<User> selectAllUsers()
	{
		List<User> users=new ArrayList<User>();
		userDAO dao=new userDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String uname=resultSet.getString("uname");
				String email=resultSet.getString("email");
				String country=resultSet.getString("country");
				String password=resultSet.getString("passwd");
				
				users.add(new User(id,uname,email,country,password));
	
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return users;
	}
	
	
	public boolean deleteUser(int id)
	{
		boolean status=false;
		userDAO dao=new userDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1, id);
			
			status=preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public boolean updateUser(User user)
	{
		boolean status=false;
		userDAO dao=new userDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			
			
			
			status=preparedStatement.executeUpdate()>0;
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
   public static void main(String args[])
   {
		/*
		 * UserDAO dao=new UserDAO(); if(dao.getConnection()!=null) {
		 * System.out.println("Successfully connected to the database!!"); } else {
		 * System.out.println("Problem in database connection!!"); }
		 */
	   
	   //Data insertion
	   //User user=new User("test","test@abc.com","India","abc@123");
	   
	   //dao.insertUser(user);
	   
	   //select data by user id
	   //User user1=dao.selectUser(1);
	   //System.out.println(user1);
	   
	   //select all users data
	   //List<User> users=dao.selectAllUsers();
	   
		/*
		 * for(User u:users) { System.out.println(u); }
		 */
	  
	  //Update user
	   
	  userDAO dao=new userDAO();
	  User user=dao.selectUser(1);
	  user.setName("demo");
	  user.setCountry("demo");
	  user.setEmail("demo@abc.com");
	  Boolean status=dao.updateUser(user);
	  System.out.println(status);
		   
   }
}