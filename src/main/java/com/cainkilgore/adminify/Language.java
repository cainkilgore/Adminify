package com.cainkilgore.adminify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Language {
	
//	public static String getStringFromFile(String string) {
//		try {
//			InputStream file = Adminify.mainClass.getResource("en-US.xml");
//			InputStreamReader is = new InputStreamReader(file);
//			BufferedReader in = new BufferedReader(is);
//			
//			String str = null;
//			while((str = in.readLine()) != null) {
//				if(str.startsWith(string)) {
//					return str.split(string + "=")[1];
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Error while reading.");
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
	
	public static String getStringFromFile(String string) {
		try {
			File file = new File("plugins/Adminify/en-US.xml");
			BufferedReader in = new BufferedReader(new FileReader(file));
			
			String str = null;
			while((str = in.readLine()) != null) {
				if(str.startsWith(string)) {
					return str.split(string + "=")[1];
				}
			}
		} catch (Exception e) {
//			System.out.println("Error while reading.");
//			System.out.println(e.getMessage());
		}
		return null;
	}

}
