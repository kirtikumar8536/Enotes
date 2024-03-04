package com.DAO;

import java.sql.*;

import com.User.UserDetails;

public class UserDAO {
	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean addUser(UserDetails udtls) {
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("insert into user(name,email,password) values (?,?,?)");
			ps.setString(1, udtls.getName());
			ps.setString(2, udtls.getEmail());
			ps.setString(3, udtls.getPassword());
			int i = ps.executeUpdate();
			System.out.println(i);
			if (i == 1) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public UserDetails loginVerify(UserDetails loginuser) {
		UserDetails user=null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");

			ps.setString(1, loginuser.getEmail());
			ps.setString(2, loginuser.getPassword());
			ResultSet rs = ps.executeQuery();
			//here we cant fetch name ,email,password from resultSet for that we need rs.next() 
			System.out.println("value of resultSet: " + rs);

			if (rs.next()) {
				//				String name = rs.getString("name");
				//				String email = rs.getString("email");
				//				String password = rs.getString("password");
				//				System.out.println("Nameof user:" + name);
				//				System.out.println("rs Email:" + email);
				//				System.out.println("password" + password);
				user=new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				//user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
//String email = rs.getString("email");
//String password = rs.getString("password");
//System.out.println("rs Email:"+email);
//System.out.println("password"+password);
/*
 * When you execute a query using the executeQuery() method, the database driver
 * returns a ResultSet object. The ResultSet object contains the results of the
 * query.
 * 
 * To access the data in the ResultSet object, you need to call the next()
 * method. The next() method moves the cursor to the next row in the result set.
 * If there are no more rows in the result set, the next() method will return
 * false.
 * 
 * If you try to access the data in the ResultSet object before calling the
 * next() method, you will get the error message java.sql.SQLException: Before
 * start of result set.
 */

/*
 * The values stored in a ResultSet object are the results of a database query.
 * The specific values that are stored will depend on the query that was
 * executed.
 * 
 * For example, if the query was SELECT * FROM user, then the ResultSet object
 * would contain the values for all of the columns in the user table. If the
 * query was SELECT name, email FROM user, then the ResultSet object would
 * contain the values for the name and email columns in the user table.
 */