package p_main;

import p_model.Data;

public class Main {
	public static void main(String[] args) {
		Data data = Data.getInstance();
		data.readAll();
	}
}
