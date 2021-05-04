package com.projectdev.openstore.util;

public class DatabaseUtil {
	
	public static String generateSqlInput(int qty){
		String input = "";
		for (int i = 0; i < qty; i++) {
			if(i == qty-1)
				input += "?";
			else	
				input += "?, "; 
		}
		return input;
	}

}
