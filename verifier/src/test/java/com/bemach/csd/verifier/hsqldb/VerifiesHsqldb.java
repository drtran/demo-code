package com.bemach.csd.verifier.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;

public class VerifiesHsqldb {

	private String hostIp;

	public Connection getConnection() {
		hostIp = System.getProperty("host-ip");
		
		Connection conn = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			String url = String.format("jdbc:hsqldb:hsql://%s:9001/xdb", hostIp);
			conn = DriverManager.getConnection(url, "SA", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
