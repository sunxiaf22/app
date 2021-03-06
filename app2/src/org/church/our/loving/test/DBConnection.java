package org.church.our.loving.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.church.our.loving.module.daos.CommonDAO;

public class DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testquery();
		
	}

	private static void testquery() {
		try {
			Connection connection = getConnection();
			List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
			Integer [] array = {1};
			res = CommonDAO.doQuery(connection,"select * from tbl_shopping_mgr where id = ? ;", array);
			System.out.println(res.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Connection c = null;
	    try {
	     // Class.forName("org.sqlite.JDBC");
	     // c = DriverManager.getConnection("jdbc:sqlite://C:/Users/Jason/mydb.db");
	    	c = getConnectionByJNDI();
	    } catch ( Exception e ) {
	      throw e;
	    }
	    return c;
	}
	
	public static Connection getConnectionByJNDI() throws Exception {
		Connection c = null;
	    try {
	    	 Context ctx = new InitialContext(); 
	    	 Context envContext = (Context)ctx.lookup("java:/comp/env");
	    	 DataSource ds = (DataSource)envContext.lookup("jdbc/mysqlite"); 
	         c = ds.getConnection();
	    } catch ( Exception e ) {
	      throw e;
	    }
	    return c;
	}
	
	
	
	public static void freeConnection (Connection connection) {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}

}
