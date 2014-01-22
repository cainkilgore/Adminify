package com.cainkilgore.adminify;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	public static Connection conn = null;
	public static Statement stat = null;

	public static void startConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		File pluginDir = new File("plugins/Adminify");
		if(!pluginDir.exists()) {
			pluginDir.mkdirs();
		}
		
		conn = DriverManager.getConnection("jdbc:sqlite:plugins/Adminify/adminify.db");
		stat = conn.createStatement();

		stat.executeUpdate("create table if not exists lastpos(player, x, y, z, world);");
		stat.executeUpdate("create table if not exists homes (player, x, y, z, world);");
		stat.executeUpdate("create table if not exists warps (warp, x, y, z, world);");
		
		// stat.executeUpdate("insert into lastpos(player, x, y, z, world) values('kyle0440', 0, 0, 0, 'world');");
		conn.setAutoCommit(false);
		
//		ResultSet result = stat.executeQuery("select * from lastpos");
//		while(result.next()) {
//			Util.print("Player: " + result.getString("player"));
//			Util.print("X: " + result.getString("x"));
//			Util.print("Y: " + result.getString("y"));
//			Util.print("Z: " + result.getString("z"));
//			Util.print("World: " + result.getString("world"));
//		}
		
		// result.close();
		// conn.close();
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			Util.print("Could not close database connection.");
		}
	}

}
