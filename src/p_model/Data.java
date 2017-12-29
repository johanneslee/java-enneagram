package p_model;

import p_util.DBConnection;

public class Data {
	public Data() {
		System.out.println("Data Constructor is started");
		
		DBConnection dbcon = new DBConnection();
		System.out.println(dbcon.findAll());
	}
}
