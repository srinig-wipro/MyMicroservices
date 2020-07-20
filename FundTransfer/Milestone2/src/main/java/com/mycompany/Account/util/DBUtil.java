package com.mycompany.Account.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	Connection conn;
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
        // creating Connection object
        conn = DriverManager.getConnection("jdbc:mysql:///devops", "root", "root");
        return conn;
	}
}// DBUtil
