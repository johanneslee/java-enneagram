package p_model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import p_interface.DataInterface;
import p_util.DBConnection;

public class Data implements DataInterface {
	private static Data instance;
	private int[] dataArray;
	private List<Map<String, Object>> dataList;
	
	public static Data getInstance() {
		if(instance == null) {
			instance = new Data();
		}
		return instance;
	}
	
	private Data() {
		DBConnection dbcon = new DBConnection();
		dataList = dbcon.findAll();
		dataArray = new int[10];
		Arrays.fill(dataArray, 0);
	}
	
	public void readAll() {
		System.out.println("Reading is started");
		for(Map<String, Object> map : dataList) {
			for(Map.Entry<String, Object> entry : map.entrySet()) {
		        System.out.println(entry.getKey() + ": " + entry.getValue());
		    }
		}
	}
	
	public void sendEvent(int type, int value) {
		dataArray[type] = value;
	}
}
