package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	//完成连接数据库操作，并生成容器返回
    public static Connection createConn(){
    	Connection conn = null;
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=StrutsGasInformation","sa","123456");
//			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=communication");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=communication","sa","123456");
    	} catch (ClassNotFoundException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return conn;
    }
	
    public static PreparedStatement prepare(Connection conn,String sql){
    	PreparedStatement ps = null;
    	try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ps;    			
    }
    
    public static void close(Connection conn){
    	if (conn == null) {
			return;
		}
    	try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void close(Statement stmt){
    	if (stmt == null) {
			return;
		}
    	try {
    		stmt.close();
    		stmt = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void close(ResultSet rs){
    	if (rs == null) {
			return;
		}
    	try {
    		rs.close();
    		rs = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
