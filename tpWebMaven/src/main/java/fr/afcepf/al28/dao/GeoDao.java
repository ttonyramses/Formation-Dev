package fr.afcepf.al28.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GeoDao {

	public  List<String> rechercheRegions() {
		Connection cn=null;
		List<String> regions=new ArrayList<String>();;
		PreparedStatement st = null; //PrepareStatement herite de Statement
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String urlDB = "jdbc:mysql://localhost/geodb";
//			cn = DriverManager.getConnection(urlDB, "root", "afcepf");
			
			InitialContext ic=new InitialContext();
			DataSource ds= (DataSource)ic.lookup("java:comp/env/"+"jdbc/geodb");
			
			cn=ds.getConnection();
			st= cn.prepareStatement("SELECT * FROM Regions WHERE num >= ?");
			st.setInt(1/*numero d'ordre du ?*/, 0 /* valeur */);
			//st.setString(2,"valeur_du_?_numero_2");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				//int numReg= rs.getInt("num");
				//String nomReg = rs.getString("nom");
				//System.out.println("[" + numReg + "] " + nomReg);
				regions.add(rs.getString("nom"));
			}
			rs.close();
			st.close();// ".close()" dans l'ordre inverse des ouvertures
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//GeoDBApp.closeRs(rs);
			//GeoDBApp.closeSt(sn);
			GeoDao.closeCn(cn); //ou idealement JdbcHelper.closeCn(cn);
		}
		return regions;
	}
	
	public static void closeCn(Connection cn){
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
