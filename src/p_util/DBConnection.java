package p_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import p_interface.DataInterface;

public class DBConnection implements DataInterface {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public DBConnection() {
		System.out.println("DBConnection Constructor is started");
		
		try {
			String url = "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_f55f228bd4e98f2";
			String id = "b0fbbd0580f94e";
			String pw = "d7df589b";
	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);			
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}

	@Override
	public String findAll() {
		String jsonData = null;
		
		System.out.println("FindAll() is started.");
		try {
			String sql = "SELECT type, question FROM enneagram_data";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			jsonData = convertToJSON(rs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonData;		
	}

	@Override
	public String findOne() {
		return null;		
	}
	
	private String convertToJSON(ResultSet tmpRs) {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        try {
	        while (tmpRs.next()) {
	            map.put("type", rs.getString("type"));
	            map.put("question", rs.getString("question"));
	            
	            list.add(map);
	        }
        }
		catch(Exception e) {
			e.printStackTrace();
		}
        
        return new Gson().toJson(list);
	}
}