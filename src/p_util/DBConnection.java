package p_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import p_config.Config;
import p_interface.DBInterface;

public class DBConnection implements DBInterface {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData md = null;
	private int columns = 0;
	List<Map<String, Object>> rows = null;
	
	public DBConnection() {
		Config config = new Config();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(config.getUrl(), config.getId(), config.getPw());			
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findAll() {		
		try {
			String sql = "SELECT id, type, question FROM enneagram_data";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			md = rs.getMetaData();
			
			columns = md.getColumnCount();			
			rows = new ArrayList<Map<String, Object>>();
			Map<String, Object> row = null;
		    while(rs.next()){
		        row = new HashMap<String, Object>(columns);
		        for(int i = 1; i <= columns; ++i){
		            row.put(md.getColumnName(i), rs.getObject(i));
		        }
		        rows.add(row);
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
		return rows;		
	}
}