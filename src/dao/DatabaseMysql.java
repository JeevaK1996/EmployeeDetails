package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;
public class DatabaseMysql {

	public DatabaseMysql(){
		
	}
	
	static {
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
		} 
	}
	
	public static Connection getConnection() throws SQLException{
		
		Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		return connection;
	}
	
	public static List<Employee> view() throws SQLException{
		Connection connection=DatabaseMysql.getConnection();
		List<Employee> list=new ArrayList<Employee>();
		Statement statement=connection.createStatement();
		String sql="select *from web";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()){
			Employee user=new Employee();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setCountry(rs.getString("country"));
			user.setState(rs.getString("state"));
			list.add(user);
		}
		if(rs!=null)
		rs.close();
		if(statement!=null)
		statement.close();
		return list;
		
	}
	public static int save(Employee employee){
		int status=0;
		try{
		Connection connection =DatabaseMysql.getConnection();	
		PreparedStatement statement=connection.prepareStatement("insert into web(id,name,country,state)values(?,?,?,?)");
		statement.setInt(1,employee.getId());
		statement.setString(2,employee.getName());
		statement.setString(3,employee.getCountry());
		statement.setString(4,employee.getState());
		status=statement.executeUpdate();
		connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public static int update(Employee employee) {
		int status=0;
		try{
			System.out.println("connection");
		Connection connection =DatabaseMysql.getConnection();	
		PreparedStatement statement=connection.prepareStatement("update web set id=?, name=?,country=?,state=? where id=?");
		statement.setInt(1,employee.getId());
		statement.setString(2,employee.getName());
		statement.setString(3,employee.getCountry());
		statement.setString(4,employee.getState());
		statement.setInt(5,employee.getId());
		System.out.println(employee.getState());
		status=statement.executeUpdate();
		connection.close();
    	}catch(Exception e){
		e.printStackTrace();
		}
		return status;
		
	}
	public static Employee getElementById(int id){
		Employee employee=new Employee();
		try{
			Connection connection=DatabaseMysql.getConnection();
			PreparedStatement statement=connection.prepareStatement("select *from web where id=? ");
			statement.setInt(1, id);
			ResultSet rs=statement.executeQuery();
			if(rs.next()){
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setCountry(rs.getString("country"));
				employee.setState(rs.getString("state"));
				
			}
		}catch(Exception e){
			//e.printStackTrace();
		}
		
		return employee;
	}
	public static int delete(Employee employee){
		int status=0;
		try{
			Connection connection=DatabaseMysql.getConnection();
			PreparedStatement statement=connection.prepareStatement("delete from web where id=?");
			statement.setInt(1,employee.getId());
			status=statement.executeUpdate();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
		
	}
	public static int deleteOut(int id){
		int status=0;
		try{
			Connection connection=DatabaseMysql.getConnection();
			PreparedStatement statement=connection.prepareStatement("delete from web where id=?");
			statement.setInt(1,id);
			status=statement.executeUpdate();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
}






























