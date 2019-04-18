package com.team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MembreSQL {


public static Connection getConnection() throws SQLException
{
		Connection con = null;
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost/teamdb?user=kamel&password=naili");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException" + e.getMessage());
			System.out.println("SQLState" + e.getSQLState());
			System.out.println("VendorError" + e.getErrorCode());
		}
		return con;
	}

public static int save(Membre m) {

	int st=0;
	try {
		Connection conn= getConnection();
		String sql="INSERT INTO `teminfo`( `name`, `password`, `email`, `java`, `scala`, `jenkis`, `git`) VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		
		preparedStatement.setString(1,m.getName());
		preparedStatement.setString(2,m.getPassword());
		
		preparedStatement.setString(3,m.getEmail());
		preparedStatement.setInt(4,m.getJava());
		preparedStatement.setInt(5,m.getScala());
		preparedStatement.setInt(6,m.getJenkis());
		preparedStatement.setInt(7,m.getGit());
		st=preparedStatement.executeUpdate();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}



public static int update(Membre m) {

	int st=0;
	try {
		Connection conn=getConnection();
		String sql="UPDATE `teminfo` SET `name`=?,`password`=?,`email`=?,`java`=?,`scala`=?,`jenkis`=?,`git`=? WHERE id=?";
		
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setString(1,m.getName());
		preparedStatement.setString(2,m.getPassword());
		preparedStatement.setString(3,m.getEmail());
		preparedStatement.setInt(4,m.getJava());
		
		
		preparedStatement.setInt(5,m.getScala());
		preparedStatement.setInt(6,m.getJenkis());
		preparedStatement.setInt(7,m.getGit());
		preparedStatement.setInt(8,m.getId());
		st=preparedStatement.executeUpdate();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}

public static int delete(int id) {

	int st=0;
	try {
		Connection conn=getConnection();
		String sql="DELETE FROM `teminfo` WHERE id=?";
		
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		
		st=preparedStatement.executeUpdate();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}

public static List<Membre> getMembre() {
	List<Membre> m=new ArrayList<Membre>();
	
	try {
		Connection conn=getConnection();
		String sql="SELECT * FROM `teminfo` ";
		
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
	
		ResultSet resultset=preparedStatement.executeQuery();

		while(resultset.next()) {
				Membre membre=new Membre();
			
				membre.setId(resultset.getInt(1));//en7oto el 7ejja eli raj3ethali resultset fi id emte3 student ow be3ed lesme welmail ow men be3ed wala 3endna student 7ather bel ma3loumette emte3o weli howa bech en7eta fi liste eli bech terja3li
				membre.setName(resultset.getString(2));
			
				membre.setPassword(resultset.getString(3));
			
				membre.setEmail(resultset.getString(4));
	                                                                                                                                                                                                                 
				membre.setJava(resultset.getInt(5));
				membre.setScala(resultset.getInt(6));
				membre.setJenkis(resultset.getInt(7));
				membre.setGit(resultset.getInt(8));
			m.add(membre);
			}
		
		
		
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return m;
}




	public static Membre getMembreId(int id) {
		Membre membre=new Membre();
		// el fonction hathi te3li affichage le Membre wa7ed ki na3ti id emte3
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM `teminfo` WHERE id=? ";
			
			PreparedStatement preparedStatement =conn.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultset=preparedStatement.executeQuery();
		
			if(resultset.next()) {
				membre.setId(resultset.getInt(1));
				membre.setName(resultset.getString(2));
			
				membre.setPassword(resultset.getString(3));
			
				membre.setEmail(resultset.getString(4));
	                                                                                                                                                                                                                 
				membre.setJava(resultset.getInt(5));
				membre.setScala(resultset.getInt(6));
				membre.setJenkis(resultset.getInt(7));
				membre.setGit(resultset.getInt(8));
				
				}
			
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return membre;

	
	

}
	
	
	
	public static List<Membre> getJava(int java) {
		List<Membre> m=new ArrayList<Membre>();
		
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM `teminfo`WHERE java=? ";
			
			PreparedStatement preparedStatement =conn.prepareStatement(sql);
			preparedStatement.setInt(1,java);
			ResultSet resultset=preparedStatement.executeQuery();

			while(resultset.next()) {
					Membre membre=new Membre();
				
					membre.setId(resultset.getInt(1));//en7oto el 7ejja eli raj3ethali resultset fi id emte3 student ow be3ed lesme welmail ow men be3ed wala 3endna student 7ather bel ma3loumette emte3o weli howa bech en7eta fi liste eli bech terja3li
					membre.setName(resultset.getString(2));
				
					membre.setPassword(resultset.getString(3));
				
					membre.setEmail(resultset.getString(4));
		                                                                                                                                                                                                                 
					membre.setJava(resultset.getInt(5));
					membre.setScala(resultset.getInt(6));
					membre.setJenkis(resultset.getInt(7));
					membre.setGit(resultset.getInt(8));
				m.add(membre);
				}
			
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}



	

	public static List<Membre> getScala(int scala) {
		List<Membre> m=new ArrayList<Membre>();
		
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM `teminfo`WHERE scala=? ";
			
			PreparedStatement preparedStatement =conn.prepareStatement(sql);
			preparedStatement.setInt(1,scala);
			ResultSet resultset=preparedStatement.executeQuery();

			while(resultset.next()) {
					Membre membre=new Membre();
				
					membre.setId(resultset.getInt(1));//en7oto el 7ejja eli raj3ethali resultset fi id emte3 student ow be3ed lesme welmail ow men be3ed wala 3endna student 7ather bel ma3loumette emte3o weli howa bech en7eta fi liste eli bech terja3li
					membre.setName(resultset.getString(2));
				
					membre.setPassword(resultset.getString(3));
				
					membre.setEmail(resultset.getString(4));
		                                                                                                                                                                                                                 
					membre.setJava(resultset.getInt(5));
					membre.setScala(resultset.getInt(6));
					membre.setJenkis(resultset.getInt(7));
					membre.setGit(resultset.getInt(8));
				m.add(membre);
				}
			
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	

	public static List<Membre> getJenkis(int jenkis) {
		List<Membre> m=new ArrayList<Membre>();
		
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM `teminfo`WHERE jenkis=? ";
			
			PreparedStatement preparedStatement =conn.prepareStatement(sql);
			preparedStatement.setInt(1,jenkis);
			ResultSet resultset=preparedStatement.executeQuery();

			while(resultset.next()) {
					Membre membre=new Membre();
				
					membre.setId(resultset.getInt(1));//en7oto el 7ejja eli raj3ethali resultset fi id emte3 student ow be3ed lesme welmail ow men be3ed wala 3endna student 7ather bel ma3loumette emte3o weli howa bech en7eta fi liste eli bech terja3li
					membre.setName(resultset.getString(2));
				
					membre.setPassword(resultset.getString(3));
				
					membre.setEmail(resultset.getString(4));
		                                                                                                                                                                                                                 
					membre.setJava(resultset.getInt(5));
					membre.setScala(resultset.getInt(6));
					membre.setJenkis(resultset.getInt(7));
					membre.setGit(resultset.getInt(8));
				m.add(membre);
				}
			
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	

	public static List<Membre> getGit(int git) {
		List<Membre> m=new ArrayList<Membre>();
		
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM `teminfo`WHERE git=? ";
			
			PreparedStatement preparedStatement =conn.prepareStatement(sql);
			preparedStatement.setInt(1,git);
			ResultSet resultset=preparedStatement.executeQuery();

			while(resultset.next()) {
					Membre membre=new Membre();
				
					membre.setId(resultset.getInt(1));//en7oto el 7ejja eli raj3ethali resultset fi id emte3 student ow be3ed lesme welmail ow men be3ed wala 3endna student 7ather bel ma3loumette emte3o weli howa bech en7eta fi liste eli bech terja3li
					membre.setName(resultset.getString(2));
				
					membre.setPassword(resultset.getString(3));
				
					membre.setEmail(resultset.getString(4));
		                                                                                                                                                                                                                 
					membre.setJava(resultset.getInt(5));
					membre.setScala(resultset.getInt(6));
					membre.setJenkis(resultset.getInt(7));
					membre.setGit(resultset.getInt(8));
				m.add(membre);
				}
			
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	
	
}
