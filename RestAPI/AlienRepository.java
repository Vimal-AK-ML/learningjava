package com.vimal.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	String url="jdbc:mysql://localhost:3306/company";
	String user="root";
	String password="Arumugam12!";
	Connection conn=null;
public AlienRepository() {
	 


	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,user,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public List<Alien> getAliens(){
	List<Alien> aliens=new ArrayList<>();
	String sql="select*from alien";
	try {
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			Alien a=new Alien();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			aliens.add(a);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return aliens;
}
public Alien getAlien(int id) {
	String sql="select*from alien WHERE id="+id;
	Alien a=new Alien();
	try {
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		if(rs.next()) {
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
	}
public void create(Alien a1) {
	String sql="insert into alien values(?,?,?)";
	try {
		PreparedStatement st=conn.prepareStatement(sql);
		st.setInt(1, a1.getId());
		st.setString(2,a1.getName());
		st.setInt(3, a1.getPoints());
		st.executeUpdate();	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public void update(Alien a1) {
	String sql="update alien set name=?,points=? where id=?";
	try {
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1,a1.getName());
		st.setInt(2, a1.getPoints());
		st.setInt(3, a1.getId());
		st.executeUpdate();	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public void deleteAlien(int id) {
	String sql="delete from alien where id=?";
	try {
		PreparedStatement st=conn.prepareStatement(sql);
		st.setInt(1, id);
		st.executeUpdate();	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
